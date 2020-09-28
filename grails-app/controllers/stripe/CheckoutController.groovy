package stripe

import com.stripe.Stripe
import com.stripe.model.Charge

class CheckoutController {

    def index() {

    }
    def checkout() {

        try {
            //Set Stripe Secret/Api Key
        
            Stripe.apiKey = "your stripe sk key here"

            def amount = Double.parseDouble(params.amount)
            def token = params.stripeToken

            if(amount && token)
                println "in controller"
                println "\n\nSTRIPE API KEY : ${Stripe.apiKey} -> TOKEN : ${token} -> AMOUNT : ${amount}\n\n"
                //convert amount into cents
                def amountInCents = (amount * 100) as Integer

                //create Stripe parameters object
                def chargeParams = [
                        'amount': amountInCents,
                        'currency': 'usd',
                        'card': token,
                        'description': "Order Placed ${amount}"
                ]

                Charge.create(chargeParams)
                flash.message = "Successfully charged Stripe"
            }
        catch (Exception e) {
            flash.message = "Something went wrong ..."
            println("Status is: " + e.printStackTrace())
        }


        }
    }
