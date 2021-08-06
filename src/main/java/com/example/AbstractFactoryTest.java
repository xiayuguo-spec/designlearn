package com.example;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlDatabaseUtils()  ;
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand iCommand = iDatabaseUtils.toCommand();
        iCommand.command();

    }
}

interface IConnection{
    void connect();
}

class MysqlConnect implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connect");
    }
}

interface ICommand{
    void command();
}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand toCommand();
}


class MysqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnect();
    }

    @Override
    public ICommand toCommand() {
        return new MysqlCommand();
    }
}