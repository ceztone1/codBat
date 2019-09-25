package sample;

public class ejercicio {


    public boolean shareDigit(int a, int b)
    {
        boolean v = false;
        int decA, decB,uniA,uniB;
        decA = a/10;
        decB = b/10;
        uniA= a%10;
        uniB=b%10;

        if (decA==decB || decA == uniB)
            v = true;
        else
        {
            v = false;
            if (uniA == decB || uniA==uniB)
                v = true;
            else
                v= false;
        }
        return v;
    }

    public String alarmClock(int day, boolean vacation)
    {
        String alarm="";
        if (vacation == true && (day ==0)||(day==6))
        {
            alarm = "off";
        }
        else
        {
            if (vacation == true && (day != 0)||( day != 6))
                alarm = "10:00";
        }
        switch (day)
        {
            case 0:
                //Cuando es domingo
                if (vacation == false)
                    alarm = "10:00";
                break;
            case 1:
                //Cuando es lunes
                if (vacation == false)
                    alarm = "7:00";
                break;
            case 2:
                //Cuando es martes
                if (vacation == false)
                    alarm = "7:00";
                break;
            case 3:
                //Cuadno es miercoles
                if (vacation == false)
                    alarm = "7:00";
                break;
            case 4:
                //Cuando es jueves
                if (vacation == false)
                    alarm = "7:00";
                break;
            case 5:
                //Cuando es viernes
                if (vacation == false)
                    alarm = "7:00";
                break;
            case 6:
                //Cuando es sabado
                if (vacation == false)
                    alarm = "10:00";
                break;
        }
        return alarm;
    }

    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep)
    {
        boolean ans = false;
        if (isMorning == true)
        {
            ans = false;
            if (isMom==true)
            {
                ans = true;
            }
            else
            {
                ans = false;
            }
        }
        else
        {
            if(isAsleep== false )
            {
                ans = true;
            }
            else
            {
                ans = false;
            }
        }
        return ans;
    }

    public boolean has271(int[] nums) {
        for (int i=0; i < (nums.length-2); i++) {
            int val = nums[i];
            if (nums[i+1] == (val+5) && Math.abs(nums[i+2] - (val-1)) <=2){
                return true;
            }
        }
        return false;
    }

    public int arrayCount9(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 9) {
                count++;
            }
        }
        return count;
    }

    public int roundSum(int a, int b, int c) {
        int sum=0;
        if(a%10 >4)
            sum+=(a/10+1)*10;
        else
            sum+=(a/10)*10;

        if(b%10 >4)
            sum+=(b/10+1)*10;
        else
            sum+=(b/10)*10;

        if(c%10 >4)
            sum+=(c/10+1)*10;
        else
            sum+=(c/10)*10;

        return sum;
    }



}
