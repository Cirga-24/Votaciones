public class Votos extends Candidatos{
    private int votosPorInternet, votosPorTv, votosPorRadio, votosUrna1, votosUrna2, votosUrna3, totalVotos,
    precioCampania, porcentaje;

    public Votos() {
    }

    public Votos(String numeral, String nombre, int votosPorInternet, int votosPorTv, int votosPorRadio, int votosUrna1, int votosUrna2, int votosUrna3){
        super(numeral, nombre);
        this.votosPorInternet = votosPorInternet;
        this.votosPorTv = votosPorTv;
        this.votosPorRadio = votosPorRadio;
        this.votosUrna1 = votosUrna1;
        this.votosUrna2 = votosUrna2;
        this.votosUrna3 = votosUrna3;
        this.totalVotos = votosUrna1 + votosUrna2 + votosUrna3;
    }

    public int getVotosPorInternet() {
        return votosPorInternet;
    }

    public void setVotosPorInternet(int votosPorInternet) {
        this.votosPorInternet = votosPorInternet;
    }

    public int getVotosPorTv() {
        return votosPorTv;
    }

    public void setVotosPorTv(int votosPorTv) {
        this.votosPorTv = votosPorTv;
    }

    public int getVotosPorRadio() {
        return votosPorRadio;
    }

    public void setVotosPorRadio(int votosPorRadio) {
        this.votosPorRadio = votosPorRadio;
    }

    public int getVotosUrna1() {
        return votosUrna1;
    }

    public void setVotosUrna1(int votosUrna1) {
        this.votosUrna1 = votosUrna1;
    }

    public int getVotosUrna2() {
        return votosUrna2;
    }

    public void setVotosUrna2(int votosUrna2) {
        this.votosUrna2 = votosUrna2;
    }

    public int getVotosUrna3() {
        return votosUrna3;
    }

    public void setVotosUrna3(int votosUrna3) {
        this.votosUrna3 = votosUrna3;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = votosUrna1 + votosUrna2 + votosUrna3;
    }

    public int getPrecioCampania() {
        return precioCampania;
    }

    public void setPrecioCampania(int precioCampania) {
        this.precioCampania = ((votosPorInternet * 700000) + (votosPorRadio * 200000) + (votosPorTv * 600000));
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void aumentarVotos(int urna, int medio) {
        switch (urna) {
            case 1 -> votosUrna1++;
            case 2 -> votosUrna2++;
            case 3 -> votosUrna3++;
        }
        switch (medio) {
            case 1 -> votosPorInternet++;
            case 2 -> votosPorRadio++;
            case 3 -> votosPorTv++;
        }

    }

    @Override
    public String toString() {
        return "Votos de " + nombre +
                "\nvotosPorInternet=" + votosPorInternet +
                "\nvotosPorTv=" + votosPorTv +
                "\nvotosPorRadio=" + votosPorRadio +
                "\nvotosUrnaNorte=" + votosUrna1 +
                "\nvotosUrnaSur=" + votosUrna2 +
                "\nvotosUrnaOccidente=" + votosUrna3 +
                "\ntotalVotos=" + totalVotos;
    }
}
