<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <h1>Example Form</h1>
        <form method="post" enctype="multipart/form-data" action="view.php">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <textarea class="form-control" id="address" name="address" required></textarea>
            </div>
            <div class="form-group">
                <label for="photo">Photo</label>
                <input type="file" class="form-control-file" id="photo" name="photo" accept="image/*" required>
            </div>
            <button type="submit" class="btn btn-primary" name="submit">Submit</button>
            <button type="button" class="btn btn-secondary" id="cancelButton">Cancel</button>
        </form>
    </div>
    <script>
        // Get a reference to the "Cancel" button
        const cancelButton = document.getElementById("cancelButton");

        // Add an event listener to the "Cancel" button
        cancelButton.addEventListener("click", function() {
            // Get a reference to the form and reset all its fields to their default values
            const form = document.querySelector("form");
            form.reset();
        });
    </script>
    
</body>
</html>