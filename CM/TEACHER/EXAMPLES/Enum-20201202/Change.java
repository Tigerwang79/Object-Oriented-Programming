package pkgenum;

public enum Change {
LIVRE(0.872),    
YEN(105.949),
DOLLAR(1.378),
ROUBLE(42.092),
EURO(1);

private double rate;

Change(double d){
    this.rate=d;
}


public double getRate(){
    return this.rate;
}

public void changeRate(double t){
this.rate=t;    
}

public double convertInEuros(double val){
return (val/this.rate);
}
}