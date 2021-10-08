package com.campdev.arpmapps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.core.location.LocationEngineRequest;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.android.telemetry.AppUserTurnstile;
import com.mapbox.android.telemetry.MapboxTelemetry;
import com.mapbox.android.telemetry.TelemetryListener;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.PlaceAutocomplete;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;


public class MapsActivity extends AppCompatActivity implements
        OnMapReadyCallback, PermissionsListener {

    public static final int READ_PHONE_STATE_PERMISSION = 100;
    private static final String LOG_TAG = "TelemetryTestApp";
    private static final long DEFAULT_INTERVAL = 2000L;
    private MapboxTelemetry mapboxTelemetry;
    private LocationEngine locationEngine;
    private LocationEngineRequest locationEngineRequest;
    private LocationEngineCallback<LocationEngineResult> locationEngineCallback;

    private static final String DESTINATION_SYMBOL_LAYER_ID = "destination-symbol-layer-id";
    private static final String DESTINATION_ICON_ID = "destination-icon-id";
    private static final String DESTINATION_SOURCE_ID = "destination-source-id";
    private FloatingActionButton searchfab;
    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
    private MapView mapView;
    private PermissionsManager permissionsManager;
    private MapboxMap mapboxMap;

    private Point origin, destination;
    private Button BtnStart;
    private NavigationMapRoute navigationMapRoute;
    private DirectionsRoute currentRoute;
    private Marker destinationMarker;

    private String geojsonSourceLayerId = "geojsonSourceLayerId";
    private String symbolIconId = "symbolIconId";

    private static final String TAG = "MapsActivity";
    private int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_maps);

        searchfab = findViewById(R.id.fab_location_search);
        mapView = (MapView) findViewById(R.id.mapViews);
        mapboxTelemetry = new MapboxTelemetry(this, obtainAccessToken(), LOG_TAG);
        mapboxTelemetry.updateDebugLoggingEnabled(true);
        mapboxTelemetry.addTelemetryListener(new TelemetryListenerWrapper(this));
        mapboxTelemetry.push(new AppUserTurnstile("fooSdk", "1.0.0"));
        locationEngine = LocationEngineProvider.getBestLocationEngine(getApplicationContext());
        locationEngineRequest = getRequest(DEFAULT_INTERVAL);
        locationEngineCallback = new LocationCallbackWrapper(this);
        checkPermissions();
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        BtnStart = findViewById(R.id.btnStart);

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status != 1) {
                    NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                            .directionsRoute(currentRoute)
                            .shouldSimulateRoute(true)
                            .build();
                    NavigationLauncher.startNavigation(MapsActivity.this, options);
                } else if (status == 1 ){
                    status = 0;
                    getNavigation(origin, destination);
                }
            }
        });
        searchfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new PlaceAutocomplete.IntentBuilder()
                        .accessToken(Mapbox.getAccessToken() != null ? Mapbox.getAccessToken() : getString(R.string.mapbox_access_token))
                        .placeOptions(PlaceOptions.builder()
                                .backgroundColor(Color.parseColor("#EEEEEE"))
                                .limit(10)
                                .build(PlaceOptions.MODE_CARDS))
                        .build(MapsActivity.this);
                startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
            }
        });

        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_navi_maps);
        chipNavigationBar.setItemSelected(R.id.maps, true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.home:
                        Intent intent = new Intent();
                        startActivity(new Intent(getApplicationContext()
                                ,HomeActivity.class));
                        overridePendingTransition(0,0);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        return;
                    case R.id.maps:
                        startActivity(new Intent(getApplicationContext()
                                ,MapsActivity.class));
                        overridePendingTransition(0,0);
                        return;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext()
                                , InfoActivity.class));
                        overridePendingTransition(0,0);
                        return;

                }

            }
        });
    }

    private void initLayers(@NonNull Style loadedMapStyle) {
        loadedMapStyle.addImage(DESTINATION_ICON_ID,
                BitmapFactory.decodeResource(this.getResources(), R.drawable.mapbox_marker_icon_default));
        GeoJsonSource geoJsonSource = new GeoJsonSource(DESTINATION_SOURCE_ID);
        loadedMapStyle.addSource(geoJsonSource);
        SymbolLayer destinationSymbolLayer = new SymbolLayer(DESTINATION_SYMBOL_LAYER_ID, DESTINATION_SOURCE_ID);
        destinationSymbolLayer.withProperties(
                iconImage(DESTINATION_ICON_ID),
                iconAllowOverlap(true),
                iconIgnorePlacement(true)
        );
        loadedMapStyle.addLayer(destinationSymbolLayer);
    }

    @SuppressLint("MissingPermission")
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            LocationComponent locationComponent = mapboxMap.getLocationComponent();

            locationComponent.activateLocationComponent(
                    LocationComponentActivationOptions.builder(this, loadedMapStyle).build()
            );

            locationComponent.setLocationComponentEnabled(true);

            locationComponent.setCameraMode(CameraMode.TRACKING);

            locationComponent.setRenderMode(RenderMode.COMPASS);
            this.origin = Point.fromLngLat(locationComponent.getLastKnownLocation().getLongitude(),
                    locationComponent.getLastKnownLocation().getLatitude());
        }else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case READ_PHONE_STATE_PERMISSION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permission granted do what you want from this point
                }else {
                    //Permission denied, manage this usecase
                }
            }
        }
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {
        Toast.makeText(this, "Grant Location Permission", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) { enableLocationComponent(style); }
            });
        }else {
            Toast.makeText(this, "Permission not granted", Toast.LENGTH_LONG).show();
            finish();
        }
    }


    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;

        mapboxMap.setStyle(new Style.Builder().fromUri(Style.MAPBOX_STREETS),
                new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                        List<Feature> symbolLayerIconFeatureList = new ArrayList<>();
                        enableLocationComponent(style);

                        initLayers(style);

                        mapboxMap.addOnMapClickListener(new MapboxMap.OnMapClickListener() {
                            @Override
                            public boolean onMapClick(@NonNull LatLng point) {
                                if(destinationMarker != null) {
                                    mapboxMap.removeMarker(destinationMarker);
                                }
                                destinationMarker = mapboxMap.addMarker(new MarkerOptions().position(point));
                                destination = Point.fromLngLat(point.getLongitude(),point.getLatitude());
                                origin = Point.fromLngLat(origin.longitude(),origin.latitude());
                                BtnStart.setEnabled(true);
                                BtnStart.setBackgroundResource(R.color.mapbox_blue);

                                getRoute(origin,destination);
                                return true;
                            }
                        });
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            CarmenFeature selectedCarmenFeature = PlaceAutocomplete.getPlace(data);

            BtnStart.setEnabled(true);
            BtnStart.setBackgroundResource(R.color.mapbox_blue);
            destination =  Point.fromLngLat(((Point)selectedCarmenFeature.geometry()).longitude(),
                    ((Point)selectedCarmenFeature.geometry()).latitude());
            getRoute(origin,destination);
            if (mapboxMap != null) {
                Style style = mapboxMap.getStyle();
                if (style != null) {
                    GeoJsonSource source = style.getSourceAs("geojsonSourceLayerId");
                    if (source != null) {
                        source.setGeoJson(FeatureCollection.fromFeatures(
                                new Feature[] {Feature.fromJson(selectedCarmenFeature.toJson())}));
                    }

                    mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                            new CameraPosition.Builder()
                                    .target(new LatLng(((Point) selectedCarmenFeature.geometry()).latitude(),
                                            ((Point) selectedCarmenFeature.geometry()).longitude()))
                                    .zoom(14)
                                    .build()), 4000);
                }
            }
        }
    }

    @Override
    @SuppressWarnings( {"MissingPermission"})
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    private String obtainAccessToken() {
        return getString(R.string.mapbox_access_token);
    }

    @SuppressLint("MissingPermission")
    private void checkPermissions() {
        boolean permissionsGranted = PermissionsManager.areLocationPermissionsGranted(this);
        if (permissionsGranted) {
            mapboxTelemetry.enable();
        } else {
            PermissionsManager permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    private static LocationEngineRequest getRequest(long interval) {
        return new LocationEngineRequest.Builder(interval)
                .setPriority(LocationEngineRequest.PRIORITY_HIGH_ACCURACY)
                .build();
    }


    private static final class LocationCallbackWrapper implements LocationEngineCallback<LocationEngineResult> {
        private final WeakReference<MapsActivity> weakReference;

        LocationCallbackWrapper(MapsActivity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        @Override
        public void onSuccess(LocationEngineResult result) {
            Location location = result.getLastLocation();
            MapsActivity mapsActivity = weakReference.get();
            if (location != null && mapsActivity != null) {
                Toast.makeText(mapsActivity, getLocationText(location), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(@NonNull Exception exception) {
            MapsActivity mapsActivity = weakReference.get();
            if (mapsActivity != null) {
                Toast.makeText(mapsActivity, exception.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        private static String getLocationText(Location location) {
            return location == null ? "Unknown location" :
                    location.getProvider() + "(" + location.getLatitude() + ", " + location.getLongitude() + ")";
        }
    }

    private static final class TelemetryListenerWrapper implements TelemetryListener {
        private final WeakReference<MapsActivity> weakReference;

        TelemetryListenerWrapper(MapsActivity mapsActivity) {
            this.weakReference = new WeakReference<>(mapsActivity);
        }

        @SuppressLint("DefaultLocale")
        @Override
        public void onHttpResponse(boolean successful, int code) {
            final String message = successful ? String.format("Transmission succeed with code: %d", code) :
                    String.format("Transmission failed with code: %d", code);
            final MapsActivity mapsActivity = weakReference.get();
            if (mapsActivity != null) {
                mapsActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mapsActivity, message, Toast.LENGTH_LONG).show();
                    }
                });
            }
            Log.i(LOG_TAG, message);
            if (!successful) {
                throw new AssertionError("Failed to POST Event: " + code);
            }
        }

        @Override
        public void onHttpFailure(final String message) {
            final MapsActivity mapsActivity = weakReference.get();
            if (mapsActivity != null) {
                mapsActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mapsActivity, message, Toast.LENGTH_LONG).show();
                    }
                });
            }
            Log.e(LOG_TAG, "Failure: " + message);
            throw new AssertionError("Failed to POST Event");
        }
    }


    private void getNavigation(Point originL, Point destination) {
        NavigationRoute.builder(getApplicationContext())
                .accessToken(getString(R.string.mapbox_access_token))
                .origin(originL)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        Timber.d("Response code: " + response.code());
                        if (response.body() == null) {
                            Toast.makeText(MapsActivity.this, "No routes found, make sure you set the right user and access token.", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (response.body().routes().size() < 1) {
                            Toast.makeText(MapsActivity.this, "No routes found", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        currentRoute = response.body().routes().get(0);

                        NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                                .directionsRoute(currentRoute)
                                .shouldSimulateRoute(true)
                                .build();
                        NavigationLauncher.startNavigation(MapsActivity.this, options);
                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {
                        Toast.makeText(MapsActivity.this, "Error: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void getRoute(Point origin, Point destination) {
        NavigationRoute.builder(this)
                .accessToken(Mapbox.getAccessToken())
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        // You can get the generic HTTP info about the response
                        Timber.d("Response code: " + response.code());
                        if (response.body() == null) {
                            Timber.e("No routes found, make sure you set the right user and access token.");
                            return;
                        } else if (response.body().routes().size() < 1) {
                            Timber.e("No routes found");
                            return;
                        }

                        // Get the directions route
                        currentRoute = response.body().routes().get(0);
                        if(navigationMapRoute != null){
                            navigationMapRoute.removeRoute();
                        }else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView,mapboxMap );
                        }
                        navigationMapRoute.addRoute(currentRoute);
                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable throwable) {
                        Timber.e("Error: " + throwable.getMessage());
                        Toast.makeText(MapsActivity.this, "Error: " + throwable.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
