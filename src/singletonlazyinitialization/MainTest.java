package singletonlazyinitialization;

import molefarm.common.MoleFarmBlock;
import molefarm.test.adapter.AdapterTest;
import molefarm.test.builder.BuilderTest;
import molefarm.test.chainOfResponsibility.ChainOfResponsibilityTest;
import molefarm.test.command.CommandTest;
import molefarm.test.factory.FactoryTest;
import molefarm.test.iterator.IteratorTest;
import molefarm.test.observer.ObserverTest;
import molefarm.test.proxy.ProxyTest;
import molefarm.test.state.StateTest;

import java.lang.reflect.Method;

public class MainTest {
    private static MainTest instance=new MainTest();
    private MainTest(){ }
    public static MainTest getInstance(){return instance;}

    //测试流程控制器
    public void TestController() throws InterruptedException {
        //moleFarm模块测试
        AdapterTest();
        BuilderTest();
        ChainOfResponsibilityTest();
        CommandTest();
        FactoryTest();
        IteratorTest();
        ObserverTest();
        ProxyTest();
        StateTest();
    }

    //1 适配器模式（Adapter Pattern）
    public void AdapterTest() {
        System.out.println("1 适配器模式（Adapter Pattern）");
        System.out.println("包:molefarm.pattern.adapter");
        System.out.println("类：MoleAdapter/WeatherAdapter");
        System.out.println("实现接口：WeatherAdapter.getInstance()");
        System.out.println("测试信息：");
        AdapterTest.WeatherTest();
        System.out.println();
    }

    //2 建造者模式（Builder Pattern）
    public void BuilderTest() {
        System.out.println("2 建造者模式（Builder Pattern）");
        System.out.println("包:molefarm.pattern.builder");
        System.out.println("类：ConcreteBuilder1/ConcreteBuilder2");
        System.out.println("实现接口：ConcreteBuilder1.buildPlant()");
        System.out.println("测试信息：");
        BuilderTest.builder1(new MoleFarmBlock(), BuilderTest.createSeed("白菜种子"));
        System.out.println();
    }

    //3 职责链模式（ChainOfResponsibility Pattern）
    public void ChainOfResponsibilityTest() {
        System.out.println("3 职责链模式（ChainOfResponsibility Pattern）");
        System.out.println("包:molefarm.pattern.chainOfResponsibility");
        System.out.println("类：ShopHandler/WareHouseHandler");
        System.out.println("实现接口：ShopHandler.provideSeeds()");
        System.out.println("测试信息：");
        ChainOfResponsibilityTest.test();
        System.out.println();
    }

    //4 命令模式（Command Pattern）
    public void CommandTest() {
        System.out.println("4 命令模式（Command Pattern）");
        System.out.println("包:molefarm.pattern.command");
        System.out.println("类：FertilizerCommand/SeedCommand");
        System.out.println("实现接口：FertilizerCommand.excute()");
        System.out.println("测试信息：");
        CommandTest.test();
        System.out.println();
    }

    //5 工厂模式（Factory Pattern）
    public void FactoryTest() {
        System.out.println("5 工厂模式（Factory Pattern）");
        System.out.println("包:molefarm.pattern.factory");
        System.out.println("类：CropsFactory/FertilizerFactory/SeedFactory/ToolFactory");
        System.out.println("实现接口：CropsFactory.newInstance()");
        System.out.println("测试信息：");
        FactoryTest.produceSeed("白菜种子");
        System.out.println();
    }

    //6 迭代器模式（Iterator Pattern）
    public void IteratorTest() {
        System.out.println("6 迭代器模式（Iterator Pattern）");
        System.out.println("包:molefarm.pattern.iterator");
        System.out.println("类：FarmIterator");
        System.out.println("实现接口：Farm.getIterator()");
        System.out.println("测试信息：");
        IteratorTest.test();
        System.out.println();
    }

    //7 观察者模式（Observer Pattern）
    public void ObserverTest() {
        System.out.println("7 观察者模式（Observer Pattern）");
        System.out.println("包:molefarm.pattern.observer");
        System.out.println("类：WeatherObserver");
        System.out.println("实现接口：WeatherObserver.getInstance()");
        System.out.println("测试信息：");
        ObserverTest.test();
        System.out.println();
    }

    //8 代理模式（Proxy Pattern）
    public void ProxyTest() {
        System.out.println("8 代理模式（Proxy Pattern）");
        System.out.println("包:molefarm.pattern.proxy");
        System.out.println("类：Proxy");
        System.out.println("实现接口：Proxy.getInstance()");
        System.out.println("测试信息：");
        ProxyTest.test();
        System.out.println();
    }

    //9 状态模式（State Pattern）
    public void StateTest() {
        System.out.println("9 状态模式（State Pattern）");
        System.out.println("包:molefarm.pattern.state");
        System.out.println("类：CloudyWeather/InsectDamageWeather/RainWeather/SunnyWeather");
        System.out.println("实现接口：CloudyWeather.getWeather()");
        System.out.println("测试信息：");
        ClassLoader classLoader = StateTest.class.getClassLoader();
        try {
            Class<?> loadClass = classLoader.loadClass("molefarm.test.state.StateTest");
            Method method = loadClass.getMethod("main", String[].class);
            method.invoke(null, new Object[] { new String[] {} } );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        MainTest mainTest = new MainTest();
        mainTest.TestController();
    }
}