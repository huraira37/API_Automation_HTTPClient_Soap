Calculator(amount1,amount2) ::= << <?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
<soap:Body>
<Multiply xmlns="http://tempuri.org/">
<intA>$amount1$</intA>
<intB>$amount2$</intB>
</Multiply>
</soap:Body>
</soap:Envelope> >>