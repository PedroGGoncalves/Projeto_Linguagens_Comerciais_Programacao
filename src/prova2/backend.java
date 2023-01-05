package prova2;
/*
 Prova 2 de Linguagens Comerciais de Programação
    Lucas Bastelli
    Lucas Mondini
    Pedro Gonçalves
    Vinicius Brunheroto
 */
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class backend {
    
    
    public List<String>
    convertStringToStringList(String str){
    
        List<String> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {

            chars.add(String.valueOf(ch));
        }
        return chars;
    }
    
    public double operacao(String expressao){
        List<String> operadores = new ArrayList<String>();
        List<Double> conta = new ArrayList<Double>();
        String operacoes[] = {"√","^","×","÷","-","+","="};
        int contador0 = 0;
        boolean flag = false;
        
        List<String> input = convertStringToStringList(expressao);
        
        
        while(contador0 < input.size()){
            flag = false;
            for (int i = 0; i < operacoes.length; i++){ // === if (input[contador0] in operacoes)
                if( (input.get(contador0)).equals(operacoes[i])){   // Compara as strings
                    flag = true;
                }
            }
            if(flag){
                operadores.add(input.get(contador0));
            }
            else{
                flag = false;
                
                for (int i = 0; i < operacoes.length; i++){ // === if (input[contador0] in operacoes)
                    
                    if( (input.get(contador0 + 1)).equals(operacoes[i])){
                        flag = true;
                    }   
                }   
                if(flag){
                    conta.add(Double.parseDouble(input.get(contador0)));
                }
                else{
                    input.set(contador0+1, input.get(contador0) + input.get(contador0 + 1));
                }
            }
            contador0++;
        }
        
        contador0 = 0; 

        
        while(contador0 < operadores.size()-1){
            if((operadores.get(contador0)).equals("√")){
                conta.set(contador0, Math.sqrt(conta.get(contador0)));
                operadores.remove(contador0);
            }
            else if((operadores.get(contador0)).equals("^")){
                conta.set(contador0, Math.pow(conta.get(contador0), conta.get(contador0 + 1)));
                operadores.remove(contador0);
                conta.remove(contador0 + 1);
            }
            else{
                contador0++;
            }
        }
        
        contador0 = 0;
        while(contador0 < operadores.size()-1){
            if((operadores.get(contador0)).equals("×")){
                conta.set(contador0 + 1, conta.get(contador0) * conta.get(contador0 + 1));
                operadores.remove(contador0);
                conta.remove(contador0);
            }
            else if((operadores.get(contador0)).equals("÷")){
                conta.set(contador0 + 1, conta.get(contador0) / conta.get(contador0 + 1));
                operadores.remove(contador0);
                conta.remove(contador0);
            }
            else{
                contador0++;
            }
        }
        
        contador0 = 0;
        //System.out.println(contador0 + " " + conta.get(contador0) + conta.get(contador0 + 1));
        while(contador0 < operadores.size()-1){
            if((operadores.get(contador0)).equals("+")){
                conta.set(contador0 + 1, conta.get(contador0) + conta.get(contador0 + 1));
                operadores.remove(contador0);
                conta.remove(contador0);
            }
            else if((operadores.get(contador0)).equals("-")){
                conta.set(contador0 + 1, conta.get(contador0) - conta.get(contador0 + 1));
                operadores.remove(contador0);
                conta.remove(contador0);
            }
            else{
                contador0++;
            }
        }
        return conta.get(0);
        
    }
}
