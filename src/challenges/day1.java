package challenges;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class day1 {

    public Integer solution(){
        Integer result = 0;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try {
            List<String[]> list = readInputChallenge();

            for (String[] pair : list) {
                if(pair.length == 2) {
                    leftList.add(Integer.parseInt(pair[0].trim()));
                    rightList.add(Integer.parseInt(pair[1].trim()));
                }
            }

        } catch(IOException a) {
            System.out.println("Erro ao fazer a leitura do arquivo.");
        }


        // 1. Emparelhe o menor número na lista da esquerda com o menor número da lista da direita
        Collections.sort(leftList);
        Collections.sort(rightList);


        // 2. Dentro de cada par, descubra a que distância estão os dois números; você precisará somar todas essas distâncias.
        // 3. Somar todas essas distâncias

        return IntStream.range(0, Math.min(leftList.size(), rightList.size()))
                .map(i -> Math.abs(leftList.get(i) - Math.abs(rightList.get(i))))
                .sum();
    }

    public List<String[]> readInputChallenge() throws IOException {
        return readFiles("src/resources/input.txt");
    }


    public List<String[]> readFiles(String arq) throws IOException {
        List<String[]> list = new ArrayList<>();
        FileReader fr = new FileReader(arq);
        BufferedReader br = new BufferedReader(fr);

        String linha = br.readLine();

        while(linha != null) {
            list.add(linha.split(" {3}"));
            linha = br.readLine();

        }

        br.close();
        fr.close();

        return list;


    }
}

