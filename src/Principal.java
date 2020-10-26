public class Principal {
    public static void main(String[] args) {
        int[][] numeromagico = {
                {16,3,2,13},
                {5,10,11,8},
                {9,6,7,12},
                {4,15,14,1}
        };
        int sumahorizonal=0;
        for(int x=0;x<numeromagico.length;x++){
            sumahorizonal=sumahorizonal+numeromagico[0][x];
        }
        System.out.println(sumahorizonal);

        int sumahorizonal2=0;
        for(int x=0;x<numeromagico.length;x++){
            sumahorizonal2=sumahorizonal2+numeromagico[1][x];
        }
        System.out.println(sumahorizonal2);


        int sumahorizonal3=0;
        for(int x=0;x<numeromagico.length;x++){
            sumahorizonal3=sumahorizonal3+numeromagico[2][x];
        }
        System.out.println(sumahorizonal3);


        int sumahorizonal4=0;
        for(int x=0;x<numeromagico.length;x++){
            sumahorizonal4=sumahorizonal4+numeromagico[3][x];
        }
        System.out.println(sumahorizonal4);

        int sumaver=0;
        for(int x=0;x<numeromagico.length;x++){
            sumaver=sumaver+numeromagico[x][0];
        }
        System.out.println(sumaver);

        int sumaver1=0;
        for(int x=0;x<numeromagico.length;x++){
            sumaver1=sumaver1+numeromagico[x][1];
        }
        System.out.println(sumaver1);

        int sumaver2=0;
        for(int x=0;x<numeromagico.length;x++){
            sumaver2=sumaver2+numeromagico[x][2];
        }
        System.out.println(sumaver2);

        int sumaver3=0;
        for(int x=0;x<numeromagico.length;x++){
            sumaver3=sumaver3+numeromagico[x][3];
        }
        System.out.println(sumaver3);

        int suma=0;
        for(int x=0;x<numeromagico.length;x++){
            suma=suma+numeromagico[x][x];
        }
        System.out.println(suma);

        int sumadia2=0;
        int j=3;
        for(int x=0;x<numeromagico.length;x++){
            sumadia2=sumadia2+numeromagico[j][x];
            j=j-1;
        }
        System.out.println(sumadia2);
    }
}


