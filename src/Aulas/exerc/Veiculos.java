package Aulas.exerc;

public class Veiculos {

        public String Marca;
        public String Modelo;
        public double Custo;

        public Veiculos(){}

        public Veiculos(String marca, String modelo, double custo){
            this.Marca = marca;
            this.Modelo = modelo;
            this.Custo = custo;

        }

        public double getCusto() {
            return this.Custo;
        }

        public String getModelo() {
            return this.Modelo;
        }

        public String getMarca() {
            return this.Marca;
        }

        public void setCusto(double custo) {
            this.Custo = custo;
        }

        public void setMarca(String marca) {
            this.Marca = marca;
        }

        public void setModelo(String modelo) {
            Modelo = modelo;
        }

}
