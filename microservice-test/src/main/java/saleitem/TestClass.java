package saleitem;

public class TestClass
{

    public static void main(String[] args)
    {

        String mainString = "helm upgrade fetest --namespace bytes :repo :chartname --version :chartversion -f :filename";
        String toBeReplaceString = ":repo";
        String newString = "--repo https://helm03.eoaas.n71.sc.sero.gic.ericsson.se/onboarded/ --ca-file C:\\_app\\helmca.crt";
        String finalStr = mainString.replaceFirst(toBeReplaceString, newString);
        System.out.println(finalStr);
    }
}