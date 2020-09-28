<html>
<head>
    <title>Index</title>
</head>
<body>
<!-- Mount the instance within a <label> -->
<!--
  Or create a <label> with a 'for' attribute,
  referencing the ID of your container.
-->
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