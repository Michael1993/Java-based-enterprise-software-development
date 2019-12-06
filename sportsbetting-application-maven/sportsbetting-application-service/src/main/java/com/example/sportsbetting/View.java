package com.example.sportsbetting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import com.example.sportsbetting.builder.PlayerBuilder;
import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.User;
import com.example.sportsbetting.domain.Wager;

public class View {

    private static final Logger LOG = LoggerFactory.getLogger(View.class);
    //private List<OutcomeOdd> outComeOdds;
    public Locale locale;
    public MessageSource messageSource;

    public View() {
        // this.outComeOdds = new ArrayList<OutcomeOdd>();
    }

    public User readPlayerData() {
        Scanner in = new Scanner(System.in);
        String name;
        String sbalance;
        int balance = 0;
        String currency;
        Currency currency1;

        // System.out.println("What is your name?");
        //LOG.info("What is your name?");
        LOG.info(messageSource.getMessage("readPlayerData.name.message", null, locale));

        name = in.nextLine();
        do {
            //System.out.println("How much money do you have (more than 0)?");
            LOG.info(messageSource.getMessage("readPlayerData.money.message", null, locale));
            sbalance = in.nextLine();
            int value = -1;

            try {
                value = Integer.parseInt(sbalance);
                if (value >= 0) {
                    balance = value;
                }

            } catch (NumberFormatException ex) {
                //not integer
                balance = -1;
            }

        } while (balance < 0);

        //System.out.println("What is your currency? (HUF, EUR or USD) ");
        LOG.info(messageSource.getMessage("readPlayerData.currency.message", null, locale));

        currency = in.nextLine();
        if (currency.equals("EUR")) {
            currency1 = Currency.EUR;
        } else if (currency.equals("USD")) {
            currency1 = Currency.USD;
        } else {
            currency1 = Currency.HUF;
        }
        return (User) new PlayerBuilder(name).balance(BigDecimal.valueOf(balance)).currency(currency1).build();
    }

    public void printWelcomeMessage(Player player) {
        //System.out.println("Welcome "+player.getName()+"!");
        LOG.info(messageSource.getMessage("printWelcomeMessage.message", new Object[] { player.getName() }, locale));

    }

    public void printBalance(Player player) {
        //System.out.println("Your balance is "+player.getBalance()+" "+player.getCurrency());
        LOG.info(messageSource.getMessage("printBalance.message", new Object[] { player.getBalance(), player.getCurrency() }, locale));

    }

    public void printOutcomeOdds(List<SportEvent> events) {
        if (events != null && !events.isEmpty()) {

            int i = 1;
            for (SportEvent event : events) {
                for (Bet bet : event.getBets()) {
                    for (Outcome outcome : bet.getOutcomes()) {
                        for (OutcomeOdd outcomeodd : outcome.getOutcomeOdds()) {
                            /*System.out.println(i +": Sport Event: "+event.getTitle()
                                    +" (start: "+event.getStartDate()
                                    +"), Bet: "+bet.getDescription()
                                    +", OutCome: "+outcome.getDescription()
                                    +", Actual odd: "+outcomeodd.getValue()
                                    +", Valid between "+ outcomeodd.getValidFrom()
                                    +" and "+ outcomeodd.getValidUntil());
                            */

                            LOG.info(messageSource.getMessage("printOutcomeOdds.message",
                                new Object[] {
                                    i,
                                    event.getTitle(),
                                    event.getStartDate(),
                                    bet.getDescription(),
                                    outcome.getDescription(),
                                    outcomeodd.getValue(),
                                    outcomeodd.getValidFrom(),
                                    outcomeodd.getValidUntil()
                                }, locale));

                            i++;
                        }
                    }

                }

            }

        }

    }

    public OutcomeOdd selectOutComeOdd(List<SportEvent> events) {

        if (events != null && !events.isEmpty()) {
            List<OutcomeOdd> outcomeOdds = new ArrayList<OutcomeOdd>();
            Scanner in = new Scanner(System.in);
            String input;
            int inputInt = 0;
            do {
                //System.out.println("What are you want to bet on? (choose a number or press 'q' for quit");
                LOG.info(messageSource.getMessage("selectOutComeOdd.message", null, locale));
                printOutcomeOdds(events);
                outcomeOdds = GetOutcomeOddsFromEvents(events);
                input = in.nextLine();
                inputInt = selectOutComeOddInputIsTrue(input, outcomeOdds.size());
                if (inputInt > -1) {
                    return outcomeOdds.get(inputInt - 1);
                }
            } while (!input.equals("q"));

        }
        return null;
    }

    private int selectOutComeOddInputIsTrue(String input, int outcomeOddsSize) {
        int value = -1;
        try {
            value = Integer.parseInt(input);
            if (value >= 1 && value <= outcomeOddsSize) {
                return value;
            }

        } catch (NumberFormatException ex) {
            return -1;
        }
        return -1;
    }

    private List<OutcomeOdd> GetOutcomeOddsFromEvents(List<SportEvent> events) {
        List<OutcomeOdd> outcomeOdds = new ArrayList<>();
        for (SportEvent event : events) {
            for (Bet bet : event.getBets()) {
                for (Outcome outcome : bet.getOutcomes()) {
                    for (OutcomeOdd outcomeodd : outcome.getOutcomeOdds()) {

                        outcomeOdds.add(outcomeodd);
                    }

                }
            }
        }
        return outcomeOdds;
    }

    public BigDecimal readWagerAmount() {
        //System.out.println("What amount do you wish to bet on it?");
        LOG.info(messageSource.getMessage("readWagerAmount.message", null, locale));
        Scanner in = new Scanner(System.in);
        String input;
        input = in.nextLine();
        int value = -1;

        try {
            value = Integer.parseInt(input);
            if (value >= 0) {
                return BigDecimal.valueOf(value);
            }

        } catch (NumberFormatException ex) {
            //not integer
            return BigDecimal.valueOf(-1);
        }
        //negative value
        return BigDecimal.valueOf(-2);
    }

    public void printWagerSaved(Wager wager) {
        LOG.info(messageSource.getMessage("printWagedSaved.message", new Object[] {
            wager.getOdd().getOutcome().getBet().getDescription(),
            wager.getOdd().getOutcome().getDescription(),
            wager.getOdd().getOutcome().getBet().getEvent().getTitle(),
            wager.getOdd().getValue(),
            wager.getAmount()
        }, locale));
    }

    public void printNotEnoughBalance(Player player) {
        //System.out.println(" You don't have enough money, your balance is "+player.getBalance()+" "+player.getCurrency());
        LOG.info(messageSource.getMessage("printNotEnoughBalance.message", new Object[] {
            player.getBalance(),
            player.getCurrency()
        }, locale));
    }

    @Transactional
    public void printResults(Player player, List<Wager> wagers) {
        if (wagers != null && wagers.size() > 0 && player != null) {

            wagers = App.findAllWagers();
            //  Hibernate.initialize(wagers);
            //  wagers.forEach(wager -> Hibernate.initialize(wager.getOdd().getOutcome().getBet()));
            /*System.out.println("Results:");*/
            LOG.info(messageSource.getMessage("printResults.Results.message", null, locale));
            boolean iswin = false;
            String win = "";
            for (Wager wager : wagers) {
                iswin = wager.isWin();
                if (iswin) {
                    win = messageSource.getMessage("printTrue", null, locale);
                } else {
                    win = messageSource.getMessage("printFalse", null, locale);
                }

                LOG.info(messageSource.getMessage("printResults.Wager.message", new Object[] {
                    wager.getOdd().getOutcome().getBet().getDescription(),
                    wager.getOdd().getOutcome().getDescription(),
                    wager.getOdd().getOutcome().getBet().getEvent().getTitle(),
                    wager.getOdd().getValue(),
                    wager.getAmount(),
                    win
                }, locale));
            }



            /* System.out.println("Your new balance is "+player.getBalance()+ " "+player.getCurrency());*/
            LOG.info(messageSource.getMessage("printResults.newBalance.message", new Object[] {
                player.getBalance(),
                player.getCurrency()
            }, locale));

        }

    }
}






