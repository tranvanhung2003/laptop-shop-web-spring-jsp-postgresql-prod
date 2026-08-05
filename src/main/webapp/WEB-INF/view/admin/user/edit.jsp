<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Edit User With Id: ${id}</title>
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
                            <h3>Edit a user with id: ${id}</h3>
                            <hr />
                            <form:form method="post" action="/admin/user/${id}/edit" modelAttribute="editUser">
                                <form:hidden path="id" disabled="true" />

                                <div class="mb-3">
                                    <label class="form-label">Email:</label>
                                    <form:input path="email" type="email" disabled="true" class="form-control" />
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Phone number:</label>
                                    <form:input path="phoneNumber" type="text" class="form-control" />
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Full Name:</label>
                                    <form:input path="fullName" type="text" class="form-control" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address:</label>
                                    <form:input path="address" type="text" class="form-control" />
                                </div>

                                <button type="submit" class="btn btn-warning">Edit</button>
                                <a href="/admin/user" class="btn btn-success">Back</a>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>