package framework.interpreter;

import framework.simplefactory.Mole;
import molefarm.common.MoleFarmWarehouse;
import singletonlazyinitialization.MoleManor;

import java.util.Scanner;

public class BuyTicket {
    private final double fare=100;
    private double money;
    private int ticket;

    public BuyTicket(Mole mole){
        this.money=mole.getMoney();
        this.ticket=mole.getTicket();
    }

    public void buyTicket(){

        System.out.println("票的价格为"+fare+"摩尔豆，"+"现有"+money+"摩尔豆");
        System.out.print("请选择买票的张数：");

        Scanner input=new Scanner(System.in);
        int num=input.nextInt();

        Expression Efare=new Number(fare);
        Expression Enum=new Number(num);
        Expression Emoney=new Number(money);

        Expression Eresult=new Sub(Emoney,new Mul(Enum,Efare));

        double result=Eresult.interpret();

        if(result>=0){
            ticket+=num;
            money=result;
            MoleManor.getPlayer().setMoney(money);
            System.out.println("购买门票成功，现有门票"+ticket+"张，"+money+"摩尔豆\n");
        }
        else{
            System.out.println("购买门票失败，现有门票"+ticket+"张，"+money+"摩尔豆\n");
        }
    }
}