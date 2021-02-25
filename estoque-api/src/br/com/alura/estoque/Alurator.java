package br.com.alura.estoque;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {

        this.pacoteBase = pacoteBase;

    }

    public Object executa(String url) {

        // produto lista
        String[] partesUrl = url.replaceFirst("/", "").split("/");
        String nomeControle = partesUrl[0] + "Controller";

        try {
            Class<?> classeControle = Class.forName(pacoteBase + nomeControle);
            Object instanciaControle = classeControle.newInstance();
            System.out.println(instanciaControle);
            return null;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
