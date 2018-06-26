package br.com.willian.aula02;

import java.util.ArrayList;

/**
 * Created by Willian on 30/09/2017.
 */

public class MeusDados {

    ArrayList<PaisModel> paises;
    private static MeusDados instance;

    public static MeusDados getInstance() {
        if (instance == null) {
            instance = new MeusDados();
            instance.init();
        }

        return instance;
    }

    private void init() {
        paises = new ArrayList<>();
        paises.add(new PaisModel(0, "América", "México", "MX", "Cidade do México", R.drawable.mexico_flag, R.drawable.mexico_pic));
        paises.add(new PaisModel(1, "América", "Brasil", "BR", "Brasília", R.drawable.brasil_flag, R.drawable.brasil_pic));
        paises.add(new PaisModel(2, "América", "Canadá", "CA", "Ottawa", R.drawable.canada_flag, R.drawable.canada_pic));
        paises.add(new PaisModel(3, "África", "África do Sul", "AS", "Pretória", R.drawable.africa_do_sul_flag, R.drawable.africa_do_sul_pic));
        paises.add(new PaisModel(4, "África", "Gana", "GA", "Acra", R.drawable.gana_flag, R.drawable.gana_pic));
        paises.add(new PaisModel(5, "África", "Egito", "EG", "Cairo", R.drawable.egito_flag, R.drawable.egito_pic));
        paises.add(new PaisModel(6, "Europa", "Alemanha", "AL", "Berlim", R.drawable.alemanha_flag, R.drawable.alemanha_pic));
        paises.add(new PaisModel(7, "Europa", "Espanha", "ES", "Madrid", R.drawable.espanha_flag, R.drawable.espanha_pic));
        paises.add(new PaisModel(8, "Europa", "Itália", "IT", "Roma", R.drawable.italia_flag, R.drawable.italia_pic));
        paises.add(new PaisModel(9, "Ásia e Oceania", "China", "CH", "Pequim", R.drawable.china_flag, R.drawable.china_pic));
        paises.add(new PaisModel(10, "Ásia e Oceania", "Japão", "JA  ", "Toquio", R.drawable.japao_flag, R.drawable.japao_pic));
        paises.add(new PaisModel(11, "Ásia e Oceania", "Austrália", "AU", "Camberra", R.drawable.australia_flag, R.drawable.australia_pic));
    }

    public ArrayList<PaisModel> getPaisesArr(String continente) {
        ArrayList<PaisModel> paisesFiltradosArr = new ArrayList<>();

        for (PaisModel paisModelInstance : this.paises) {
            if (paisModelInstance.getContinente().equalsIgnoreCase(continente)) {
                paisesFiltradosArr.add(paisModelInstance);
            }
        }

        return paisesFiltradosArr;
    }

    public PaisModel getPais(int id) {
        return paises.get(id);
    }
}
