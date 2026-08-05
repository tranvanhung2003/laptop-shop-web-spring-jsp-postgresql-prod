<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Delete User With Id: ${id}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <!-- <link href="/css/demo.css" rel="stylesheet"> -->

            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Delete a user with id: ${id}</h3>

                            <hr />

                            <div class="alert alert-danger">
                                Are you sure you want to delete this user with id: ${id}?
                            </div>
                            <form:form method="post" action="/admin/user/${id}/delete">
                                <button type="submit" class="btn btn-danger">Delete</button>
                                <a href="/admin/user" class="btn btn-success">Back</a>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>