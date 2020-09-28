package stripe

import com.stripe.Stripe
import com.stripe.model.Charge

class CheckoutController {

    def index() {

    }
    def checkout() {

        try {
            //Set Stripe Secret/Api Key
            //shahmirminhas08@gmail.com for stripe pk keys psd 0331*****60sM

            Stripe.apiKey = "sk_test_51HHoS7L09pbRi9D7Te6pE0KqMHdfZTdaGS2pEduHkHp1Y78Z02AczPBRPpdrpSqVwxq8p8rWf6xjnvRR7T36XZOd00TLVN9kWB"

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
