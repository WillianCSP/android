package br.com.bsavoini.aula03_final;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Bruno on 06/10/2017.
 */

public class MyData {
  private static MyData instance;
  private ArrayList<EmailModel> emailsArr;

  public static MyData getInstance() {
    if (instance == null) {
      instance = new MyData();
      instance.loadEmails();
    }

    return instance;
  }

  public ArrayList<EmailModel> getEmails() {
    return emailsArr;
  }

  private void loadEmails() {
    emailsArr = new ArrayList<>();

    emailsArr.add(new EmailModel(0, "Equipe Gmail", "Bem Vindo ao Gmail", "Você acabou de criar sua conta, aproveite todos os recursos.", "07/10/2017"));
    emailsArr.add(new EmailModel(1, "Trivago", "Pensou em Hotel?", "Compare mais de 200 sites de reserva e encontre o hotel ideal pelo melhor preço! + de 1 milhão de hotéis · Baixar app para celular", "06/10/2017"));
    emailsArr.add(new EmailModel(2, "Amazon", "Saiba mais sobre nós", "Amazon.com é uma empresa transnacional de comércio electrónico dos Estados Unidos com sede em Seattle, estado de Washington.", "05/10/2017"));
    emailsArr.add(new EmailModel(3, "Saraiva", "Seu pedido chegou!", "Eba! Compre em até 12x s/ Juros com Cartão Saraiva e em até 10x nos Demais Cartões. Maior Livraria do Brasil · Referência em Tecnologia · Especialista em Games.", "05/10/2017"));
    emailsArr.add(new EmailModel(4, "Programa Dotz", "Seus créditos vão expirar!", "Fique atento, esta é a sua última oportunidade de trocar seus pontos.", "04/10/2017"));
    emailsArr.add(new EmailModel(5, "Spotify", "Teste o Spotify® Premium - Música para todos os momentos", "Spotify Premium por 30 dias grátis. E depois apenas R$ 16,90/mês. Playlists para o momento · Qualidade de som Premium · Descobrir novos artistas", "01/10/2017"));
    emailsArr.add(new EmailModel(6, "AES Eletropaulo", "Sua conta de luz chegou!", "Veja a fatura deste mês.", "01/10/2017"));
    emailsArr.add(new EmailModel(7, "Linkedin", "Bruno te enviou uma mensagem", "Olá! Gostaria de te adicionar à minha rede de contatos.", "27/09/2017"));
    emailsArr.add(new EmailModel(8, "Facebook", "Lembrete de senha", "Seu lembrete de senha é: 'primeiro dog'", "26/09/2017"));
    emailsArr.add(new EmailModel(9, "Github", "Você foi adicionado ao time Android", "Olá! Confirme aqui sua participação!", "26/09/2017"));
    emailsArr.add(new EmailModel(10, "Imobiliária", "Boleto", "Segue anexo o bolteo referente ao aluguel deste mês.", "26/09/2017"));
    emailsArr.add(new EmailModel(11, "Assine Abril", "Oferta imperdível!", "Assine por 10 mesese ganhe + 2!", "17/09/2017"));
    emailsArr.add(new EmailModel(12, "Ingresso Rápido", "Não perca a estréia dos filmes desta semana!", "2 concorrentes ao Oscar estreiam esta semana.", "15/09/2017"));
    emailsArr.add(new EmailModel(13, "Net", "Fatura NET", "Baixe aqui a fatura.", "07/10/2017"));
  }

  public EmailModel getEmailModel(int id) {
    return emailsArr.get(id);
  }

}