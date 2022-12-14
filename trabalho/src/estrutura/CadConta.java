package estrutura;

import entities.Conta;
import interfaces.Vetor;

import java.util.ArrayList;

public class CadConta implements Vetor {
    private ArrayList<Conta> arrayContas;

    public CadConta(int tamanho) {
        this.arrayContas = new ArrayList<>(tamanho);
    }

    public void inserirVetor(Conta conta) {
        this.arrayContas.add(conta);
    }

    public int getTamanhoVetor() {
        return this.arrayContas.size();
    }

    public Conta getConta(int posicao) {
        return arrayContas.get(posicao);
    }

    public void limpar() {
        this.arrayContas.clear();
    }

    public ArrayList<Conta> getArrayContas() {
        return this.arrayContas;
    }

    public int pesqBinaria (String nome) {
        int meio, esq, dir;
        esq = 0;
        dir = this.arrayContas.size() - 1;
        while (esq <= dir){
            meio = (esq + dir) / 2;
            /*String numeroContaString = Integer.toString(this.arrayContas.get(meio).getNumeroDaConta());
            int numeroDaContaInt = Integer.parseInt(numeroContaString.substring(1));*/
            if (nome.equalsIgnoreCase(this.arrayContas.get(meio).getNome()))
                return meio;
            else{
                if (nome.compareTo(this.arrayContas.get(meio).getNome()) < 0)
                    dir = meio - 1;
                else
                    esq = meio + 1;
            }
        }
        return -1;
    }

    public Conta picAccount(String nomeConta) {
        for (Conta conta : this.arrayContas) {
            if (conta.getNome().equalsIgnoreCase(nomeConta)) {
                return conta;
            }
        }
        return null;
    }

    public void shellsort (ArrayList<Conta> arrayContas){
        int i, j, h;
        Conta temp;
        h = 1;
        do{
            h = 3*h+1;
        }while (h < arrayContas.size());
        do{
            h = h/3;
            for (i=h; i < arrayContas.size(); i++){
                temp = arrayContas.get(i);
                j = i;

                while (arrayContas.get(j - h).comparar(temp) > 0) {
                    arrayContas.set(j, arrayContas.get(j - h));
                    j -= h;
                    if (j < h)
                        break;
                }
                arrayContas.set(j, temp);
            }
        }while (h != 1);
    }

    public void quicksort(ArrayList<Conta> arrayContas) {
        ordena (arrayContas, 0, arrayContas.size() - 1);
    }

    private void ordena (ArrayList<Conta> arrayContas, int esq, int dir) {
        int i = esq, j = dir;
        Conta temp;
        Conta pivo = arrayContas.get((i + j) / 2);
        try {
            do {
                while (arrayContas.get(i).comparar(pivo) < 0) {
                    i++;
                }
                while (arrayContas.get(j).comparar(pivo) > 0) {
                    j--;
                }
                if (i <= j) {
                    temp = arrayContas.get(i);
                    arrayContas.set(i, arrayContas.get(j));
                    arrayContas.set(j, temp);
                    i++;
                    j--;
                }
            } while (i <= j);
            if (esq < j ) {
                ordena(arrayContas, esq, j);
            }
            if (dir > i ) {
                ordena(arrayContas, i, dir);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Estourou");
        }
    }


    public String toString() {
        String resultado = "";
        for (int i = 0; i < this.getTamanhoVetor(); i++) {
            resultado += this.getConta(i) + "\n";
        }
        return resultado;
    }
}
