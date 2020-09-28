<html>
<head>
    <title>Index</title>
</head>
<body>
<label for="card-element">Card</label>
<div id="card-element"></div>
<script src="https://js.stripe.com/v3/"></script>
<script>
    var elements = stripe.elements();
    var cardElement = elements.getElement('card');
    cardElement.mount('#card-element');
</script>
</body>
</html>