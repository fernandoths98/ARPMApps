<?php
include 'config.php';
$id_mobil_toyota = $_GET['id_mobil_toyota'];
$ambil = mysqli_query($con, "SELECT * FROM tbl_toyota WHERE id_mobil_toyota='$id_mobil_toyota'");
$pecah = mysqli_fetch_assoc($ambil);
?>

<!--
=========================================================
Material Dashboard - v2.1.2
=========================================================

Product Page: https://www.creative-tim.com/product/material-dashboard
Copyright 2020 Creative Tim (https://www.creative-tim.com)
Coded by Creative Tim

=========================================================
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    PANEL ARPM
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo"><a href="#" class="simple-text logo-normal">
          PANEL ARPM
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
        <li class="nav-item ">
            <a class="nav-link" href="./index.php">
              <i class="material-icons">dashboard</i>
              <p>Table Database ALL Brands</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./tbldaihatsu.php">
              <i class="material-icons">dashboard</i>
              <p>Table Database Daihatsu</p>
            </a>
          </li>
          <li class="nav-item active  ">
            <a class="nav-link" href="./tbltoyota.php">
              <i class="material-icons">dashboard</i>
              <p>Table Database Toyota</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./tblhonda.php">
              <i class="material-icons">dashboard</i>
              <p>Table Database Honda</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./user.php">
              <i class="material-icons">person</i>
              <p>User Profile</p>
            </a>
          </li>
          
        
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:;">Dashboard</a>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">Update Database Toyota</h4>
                  
                </div>
                <div class="card-body">
                  <form enctype="multipart/form-data" method="POST">
                    <div class="table-responsive">
                      <table class="table">
                        <thead class=" text-primary">
                          <th>ID Mobil</th>
                          <th>Link Image Mobil</th>
                          <th>Nama Mobil</th>
                          <th>Varian Mobil</th>
                          <th>Tipe Body Mobil</th>
                          <th>Bahan Bakar Mobil</th>
                          <th>Transmisi Mobil</th>
                          <th>Harga Mobil</th>
                          <th>Data Topsis</th>
                          <th>Deskripsi Mobil</th>
                          <th>Alamat Dealer Mobil</th>
                          <th>Nomor Sales Mobil</th>
                        </thead>
                        <tbody>
                          <tr>
                            <td><input type="text" class="form-control" name="id_mobil_toyota" value="<?= $pecah['id_mobilall']; ?>"></td>
                            <td><input type="text" class="form-control" name="link_img_toyota"  value="<?= $pecah['link_img_all']; ?>"></td>
                            <td><input type="text" class="form-control" name="nama_mobil_toyota"  value="<?= $pecah['nama_mobil']; ?>"></td>
                            <td><input type="text" class="form-control" name="varian_mobil_toyota"  value="<?= $pecah['varian_mobil']; ?>"></td>
                            <td><input type="text" class="form-control" name="tipebody_mobil_toyota" value="<?= $pecah['tipebody_mobil_all']; ?>"></td>
                            <td><input type="text" class="form-control" name="bb_mobil_toyota"  value="<?= $pecah['bb_mobil']; ?>"></td>
                            <td><input type="text" class="form-control" name="transmisi_mobil_toyota"  value="<?= $pecah['transmisi_mobil']; ?>"></td>
                            <td><input type="text" class="form-control" name="harga_mobil_toyota"  value="<?= $pecah['harga_mobil']; ?>"></td>
                            <td><input type="text" class="form-control" name="data_topsis_toyota" value="<?= $pecah['data_topsis']; ?>"></td>
                            <td><input type="text" class="form-control" name="desc_mobil_toyota"  value="<?= $pecah['desc_mobil_all']; ?>"></td>
                            <td><input type="text" class="form-control" name="alamat_dealer_mobil_toyota"  value="<?= $pecah['alamat_dealer_mobil_all']; ?>"></td>
                            <td><input type="text" class="form-control" name="no_tlp_mobil_toyota"  value="<?= $pecah['no_tlp_mobil_all']; ?>"></td>
                          </tr>
                        </tbody>
                      </table>
                      <button type="submit" class="btn btn-primary pull-right" name="update">Update Database Daihatsu</button>
                      <div class="clearfix"></div>
                    </div>
                  </form>
                  <?php
                    if (isset($_POST['update'])) {
                        mysqli_query($con, "UPDATE tbl_toyota SET 
                                                   id_mobil_toyota='$_POST[id_mobil_toyota]',
                                                   link_img_toyota='$_POST[link_img_toyota]',
                                                   nama_mobil_toyota='$_POST[nama_mobil_toyota]',
                                                   varian_mobil_toyota='$_POST[varian_mobil_toyota]',
                                                   tipebody_mobil_toyota='$_POST[tipebody_mobil_toyota]',
                                                   bb_mobil_toyota='$_POST[bb_mobil_toyota]',
                                                   transmisi_mobil_toyota='$_POST[transmisi_mobil_toyota]',
                                                   harga_mobil_toyota='$_POST[harga_mobil_toyota]',
                                                   data_topsis_toyota='$_POST[data_topsis_toyota]',
                                                   desc_mobil_toyota='$_POST[desc_mobil_toyota]',
                                                   alamat_dealer_mobil_toyota='$_POST[alamat_dealer_mobil_toyota]',
                                                   no_tlp_mobil_toyota='$_POST[no_tlp_mobil_toyota]'
                                                   WHERE
                                                   id_mobil_toyota='$id_mobil_toyota'");
                               echo "<script>alert('Data Berhasil Di Ubah');</script>";
                               echo "<script>location='./tbltoyota.php';</script>";
            }
            ?>
                </div>
              </div>
            </div>
      </div>
      
      <footer class="footer">
        
      </footer>
    </div>
  </div>
  <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
      <a href="#" data-toggle="dropdown">
        <i class="fa fa-cog fa-2x"> </i>
      </a>
      <ul class="dropdown-menu">
        <li class="header-title"> Sidebar Filters</li>
        <li class="adjustments-line">
          <a href="javascript:void(0)" class="switch-trigger active-color">
            <div class="badge-colors ml-auto mr-auto">
              <span class="badge filter badge-purple" data-color="purple"></span>
              <span class="badge filter badge-azure" data-color="azure"></span>
              <span class="badge filter badge-green" data-color="green"></span>
              <span class="badge filter badge-warning" data-color="orange"></span>
              <span class="badge filter badge-danger" data-color="danger"></span>
              <span class="badge filter badge-rose active" data-color="rose"></span>
            </div>
            <div class="clearfix"></div>
          </a>
        </li>
        
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Plugin for the momentJs  -->
  <script src="../assets/js/plugins/moment.min.js"></script>
  <!--  Plugin for Sweet Alert -->
  <script src="../assets/js/plugins/sweetalert2.js"></script>
  <!-- Forms Validations Plugin -->
  <script src="../assets/js/plugins/jquery.validate.min.js"></script>
  <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="../assets/js/plugins/jquery.bootstrap-wizard.js"></script>
  <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="../assets/js/plugins/bootstrap-selectpicker.js"></script>
  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="../assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
  <script src="../assets/js/plugins/jquery.dataTables.min.js"></script>
  <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="../assets/js/plugins/bootstrap-tagsinput.js"></script>
  <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
  <script src="../assets/js/plugins/jasny-bootstrap.min.js"></script>
  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="../assets/js/plugins/fullcalendar.min.js"></script>
  <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
  <script src="../assets/js/plugins/jquery-jvectormap.js"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="../assets/js/plugins/nouislider.min.js"></script>
  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <!-- Library for adding dinamically elements -->
  <script src="../assets/js/plugins/arrive.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chartist JS -->
  <script src="../assets/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../assets/js/material-dashboard.js?v=2.1.2" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="../assets/demo/demo.js"></script>
  <script>
    $(document).ready(function() {
      $().ready(function() {
        $sidebar = $('.sidebar');

        $sidebar_img_container = $sidebar.find('.sidebar-background');

        $full_page = $('.full-page');

        $sidebar_responsive = $('body > .navbar-collapse');

        window_width = $(window).width();

        fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

        if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
          if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
            $('.fixed-plugin .dropdown').addClass('open');
          }

        }

        $('.fixed-plugin a').click(function(event) {
          // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
          if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
              event.stopPropagation();
            } else if (window.event) {
              window.event.cancelBubble = true;
            }
          }
        });

        $('.fixed-plugin .active-color span').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-color', new_color);
          }

          if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data-color', new_color);
          }
        });

        $('.fixed-plugin .background-color .badge').click(function() {
          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('background-color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-background-color', new_color);
          }
        });

        $('.fixed-plugin .img-holder').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).parent('li').siblings().removeClass('active');
          $(this).parent('li').addClass('active');


          var new_image = $(this).find("img").attr('src');

          if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            $sidebar_img_container.fadeOut('fast', function() {
              $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
              $sidebar_img_container.fadeIn('fast');
            });
          }

          if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $full_page_background.fadeOut('fast', function() {
              $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
              $full_page_background.fadeIn('fast');
            });
          }

          if ($('.switch-sidebar-image input:checked').length == 0) {
            var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
          }
        });

        $('.switch-sidebar-image input').change(function() {
          $full_page_background = $('.full-page-background');

          $input = $(this);

          if ($input.is(':checked')) {
            if ($sidebar_img_container.length != 0) {
              $sidebar_img_container.fadeIn('fast');
              $sidebar.attr('data-image', '#');
            }

            if ($full_page_background.length != 0) {
              $full_page_background.fadeIn('fast');
              $full_page.attr('data-image', '#');
            }

            background_image = true;
          } else {
            if ($sidebar_img_container.length != 0) {
              $sidebar.removeAttr('data-image');
              $sidebar_img_container.fadeOut('fast');
            }

            if ($full_page_background.length != 0) {
              $full_page.removeAttr('data-image', '#');
              $full_page_background.fadeOut('fast');
            }

            background_image = false;
          }
        });

        $('.switch-sidebar-mini input').change(function() {
          $body = $('body');

          $input = $(this);

          if (md.misc.sidebar_mini_active == true) {
            $('body').removeClass('sidebar-mini');
            md.misc.sidebar_mini_active = false;

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

          } else {

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

            setTimeout(function() {
              $('body').addClass('sidebar-mini');

              md.misc.sidebar_mini_active = true;
            }, 300);
          }

          // we simulate the window Resize so the charts will get updated in realtime.
          var simulateWindowResize = setInterval(function() {
            window.dispatchEvent(new Event('resize'));
          }, 180);

          // we stop the simulation of Window Resize after the animations are completed
          setTimeout(function() {
            clearInterval(simulateWindowResize);
          }, 1000);

        });
      });
    });
  </script>
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
  </script>
</body>

</html>