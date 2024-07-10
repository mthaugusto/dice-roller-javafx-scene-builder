package com.matheus.leite;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class PrimaryController {

    Random random = new Random();

    @FXML
    private ImageView imagemDado;
    
    @FXML
    private ImageView imagemDadoUmSegundaTela;

    @FXML
    private ImageView imagemDadoDoisSegundaTela;

    @FXML
    private Button botaoUmDado;

    @FXML
    private Button botaoDoisDados;

    @FXML
    private Button botaoDado;

    @FXML
    private Button botaoDadoSegundaTela;

    @FXML
    private AnchorPane telaUmDado;

    @FXML 
    private AnchorPane telaDoisDados;

    public void mostrarPrimeiraTela() {
        telaUmDado.setVisible(true);
        telaDoisDados.setVisible(false);
    };


    public void mostrarSegundaTela() {
        telaUmDado.setVisible(false);
        telaDoisDados.setVisible(true);
    };

    public void jogarDado() {
        botaoDado.setDisable(true);
        botaoUmDado.setDisable(true);
        botaoDoisDados.setDisable(true);
        botaoDadoSegundaTela.setDisable(true);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        if (telaUmDado.isVisible()) {
                            int dado = random.nextInt(6) + 1;
                            Image image = new Image(getClass().getResourceAsStream("/com/matheus/leite/images/dice-" + dado + ".png"));
                            imagemDado.setImage(image);
                            Thread.sleep(100);
                        } 

                        else {
                            int dadoUm = random.nextInt(6) + 1;
                            int dadoDois = random.nextInt(6) + 1;
                            Image imageUm = new Image(getClass().getResourceAsStream("/com/matheus/leite/images/dice-" + dadoUm + ".png"));
                            imagemDadoUmSegundaTela.setImage(imageUm);
                            Image imageDois = new Image(getClass().getResourceAsStream("/com/matheus/leite/images/dice-" + dadoDois + ".png"));
                            imagemDadoDoisSegundaTela.setImage(imageDois);
                            Thread.sleep(100);
                        }
                    }
                    botaoUmDado.setDisable(false);
                    botaoDoisDados.setDisable(false);
                    botaoDado.setDisable(false);
                    botaoDadoSegundaTela.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}
