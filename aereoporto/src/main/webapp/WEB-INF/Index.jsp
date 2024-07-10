<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gestione Prenotazioni Aeroporto</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="Index.jsp">Aeroporto</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="Index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="UpdateUtente.jsp">Prenota</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contatti</a>
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
				<form>
					<div class="form-group">
						<label for="name">Nome</label> <input type="text"
							class="form-control" id="name"
							placeholder="Inserisci il tuo nome">
					</div>
					<div class="form-group">
						<label for="flightNumber">Numero del Volo</label> <input
							type="text" class="form-control" id="flightNumber"
							placeholder="Inserisci il numero del volo">
					</div>
					<div class="form-group">
						<label for="date">Data</label> <input type="date"
							class="form-control" id="date">
					</div>
					<button type="submit" class="btn btn-primary">Prenota</button>
				</form>
			</div>
		</div>

		<!-- Tabella Prenotazioni -->
		<div class="card mt-4">
			<div class="card-header">Prenotazioni esistenti</div>
			<div class="card-body">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Numero del Volo</th>
							<th>Data</th>
							<th>Azioni</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Mario Rossi</td>
							<td>AZ1234</td>
							<td>2024-07-01</td>
							<td><button class="btn btn-danger btn-sm">Cancella</button></td>
						</tr>
						<tr>
							<td>Giulia Bianchi</td>
							<td>BA5678</td>
							<td>2024-07-02</td>
							<td><button class="btn btn-danger btn-sm">Cancella</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
