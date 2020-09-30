package stripe

class PaymentController {

    def index() {
        println params
        println "before index redirect"
        redirect  controller: 'payment', action: 'paymentStripe'
        println "after index redirect"
    }

    def paymentStripe(){
        println params
        println "payment stripe"
    }
}
