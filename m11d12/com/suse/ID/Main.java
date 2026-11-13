//package m11d12.com.suse.ID;

import java.time.LocalDate;
import java.util.Scanner;
import java.math.*;

class CardID {

    private String cardNum;

    public void setCardNum(String id) {
        cardNum = id;
    }

    public boolean lengthVerify() {
        return cardNum.length() == 18;
    }

    public boolean charVerify() {
        
        for (int i = 0; i <= 16; i++) {
            char c = cardNum.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        char last = cardNum.charAt(17);
        if (!((last >= '0' && last <= '9') || last == 'X' || last == 'x')) return false;
        return true;
    }

    public boolean checkcodeVerify() {
        String testNum = cardNum.substring(0, 17) + '0';

        int ai, wi, sum = 0;
        for (int i = 18; i >= 1; i--) {
            ai = testNum.charAt(18 - i) - '0';
            wi = (int)Math.pow(2, i - 1) % 11;
            sum += ai * wi;
        }
        int mod = sum % 11;
        char last[] = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        return this.cardNum.toUpperCase().charAt(17) == last[mod];
    }

    public void output(LocalDate today) {
        int birthYear, birthMonth, birthDay;
        birthYear = Integer.parseInt(cardNum.substring(6, 10));
        birthMonth = Integer.parseInt(cardNum.substring(10, 12));
        birthDay = Integer.parseInt(cardNum.substring(12, 14));

        System.out.println("正确的身份证号码：" + cardNum);
        System.out.println("您的生日：" + birthYear + "年" + birthMonth + "月" + birthDay + "日");
        System.out.println("当前日期：" + today.getYear() + "年" + today.getMonthValue() + "月" + today.getDayOfMonth() + "日");
        int age = today.getYear() - birthYear;
        if (today.getMonthValue() < birthMonth) age--;
        if (today.getMonthValue() == birthMonth && today.getDayOfMonth() < birthDay) age--;
        if (today.getMonthValue() == birthMonth && today.getDayOfMonth() == birthDay) System.out.println("生日快乐");
        System.out.println("您的年龄：" + age + "岁");
        System.out.println("您的性别：" + (cardNum.charAt(16) % 2 == 1 ? "男性" : "女性"));
    }

    
}

public class Main {
    public static void main(String[] args) {
        //用死循环反复测试输入、验证、输出
        //注意第一步验证失败不能进入第二步，第二步失败不能进入第三步，所有验证通过才能进行输出。
        CardID cardID=new CardID();
        String id="";
        Scanner sc=new Scanner(System.in);
        LocalDate today=LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        sc.nextLine();
        while(true){
            //System.out.print("请输入身份证号码:");
            id=sc.nextLine();
            if(id.equals("0")) break;
            cardID.setCardNum(id);
            if(!cardID.lengthVerify()){
                System.out.println("身份证号码长度有误。");
                continue;
            }
            if(!cardID.charVerify()){
                System.out.println("身份证号码有非法字符。");
                continue;
            }

            if(!cardID.checkcodeVerify()){
                System.out.println("身份证号码校验码有误。");
                continue;
            }
            //System.out.println("号码正确");
            cardID.output(today);
        }
    }
}