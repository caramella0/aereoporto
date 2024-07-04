<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gestione Prenotazioni Aeroporto</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Aeroporto</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Prenota</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contatti</a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- Main Content -->
  <div class="container mt-5">
    <h1 class="text-center">Prenotazioni Aeroporto</h1>
    
    <!-- Form di Prenotazione -->
    <div class="card mt-4">
      <div class="card-header">Prenota un volo</div>
      <div class="card-body">
        <form action="UpdateUtente" method="post">
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="firstName">Nome</label>
              <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Inserisci il tuo nome">
            </div>
            <div class="form-group col-md-6">
              <label for="lastName">Cognome</label>
              <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Inserisci il tuo cognome">
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="email">Email</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Inserisci la tua email">
            </div>
            <div class="form-group col-md-6">
              <label for="phone">Telefono</label>
              <input type="tel" class="form-control" id="phone" name="phone" placeholder="Inserisci il tuo numero di telefono">
            </div>
          </div>
          <div class="form-group">
            <label for="flightNumber">Numero del Volo</label>
            <input type="text" class="form-control" id="flightNumber" name="flightNumber" placeholder="Inserisci il numero del volo">
          </div>
          <div class="form-group">
            <label for="date">Data del Volo</label>
            <input type="date" class="form-control" id="date" name="date">
          </div>
          <div class="form-group">
            <label for="destination">Destinazione</label>
            <input type="text" class="form-control" id="destination" name="destination" placeholder="Inserisci la destinazione">
          </div>
          <button type="submit" class="btn btn-primary">Prenota</button>
        </form>
      </div>
    </div>
  </div>

  <!-- Scripts -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
