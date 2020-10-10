<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>

<body>
    <div class="container-fluid">
        <div class="jumbotron">
            <h1>Gerenciamento de Países</h1>
            <p>Nesta página você pode listar, criar, alterar ou excluir países...</p>
        </div>

        <form action="/create" method="POST">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" placeholder="Informe o nome do país" id="nome" name="nome" />
            </div>
            <div class="form-group">
                <label for="sigla">Sigla:</label>
                <input type="text" class="form-control" placeholder="Informe a sigla do país" id="sigla" name="sigla" />
            </div>

            <input type="submit" class="btn btn-primary" value="Salvar" />
        </form>

        <div class="mt-5">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Sigla</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <#list listaPaises as pais>
                        <tr>
                            <td>${pais.nome}</td>
                            <td>${pais.sigla}</td>
                            <td>
                                <button type="button" class="btn btn-warning">Alterar</button>
                                <a href="/delete?id=${pais.id}" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>

    </div>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>

</html>
