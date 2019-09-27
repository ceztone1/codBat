--Creacion BD--
create database coding;
use coding;
create table problema(
idProblema int not null,
nombre varchar(50),
clasificacion varchar(50),
dificultad int,
constraint pk1problema primary key (idProblema));

create table solucion(
idSolucion int not null,
idProblema int not null,
codigo text,
constraint pk1solucion primary key (idSolucion,idProblema),
constraint fk1solucion foreign key (idProblema) references problema(idProblema));



--Insercion de datos--
insert into problema
values (1,"ArrayCount","WARMUP",2);

insert into problema
values (2,"roundSum","LOGIC",2);

insert into problema
values (3,"alarmClock","LOGIC",1);

insert into problema
values (4,"shareDigit","LOGIC",1);

insert into problema
values (5,"answerCell","LOGIC",1);

insert into problema
values (6,"has271","WARMUP",2);

insert into problema
values (7,"evenlySpaced","LOGIC",2);

insert into problema
values (8,"Pairs","MAP",2);

insert into problema
values (9,"allSwap","MAP",2);




insert into solucion
values (1,1,   "public int arrayCount9(int[] nums) {\n
          int cont=0;\n
          for(int i=0;i<nums.length;i++){\n
            if(nums[i]==9){\n
              cont++;\n
            }\n
          }\n
          return cont;\n
        }\n"
);
insert into solucion
values (2,1,"public int arrayCount9(int[] nums) {\n
          int count = 0;\n
          for (int i=0; i<nums.length; i++) {\n
            if (nums[i] == 9) {\n
              count++;\n
            }\n
          }\n
          return count;\n"
);

insert into solucion
values (1,2,   "public int roundSum(int a, int b, int c) {\n
        int sum=0;\n
        if(a%10 >4)\n
          sum+=(a/10+1)*10;\n
        else\n
           sum+=(a/10)*10;\n
        if(b%10 >4)\n
           sum+=(b/10+1)*10;\n
        else\n
           sum+=(b/10)*10;\n
        if(c%10 >4)\n
           sum+=(c/10+1)*10;\n
        else\n
           sum+=(c/10)*10;\n
         return sum; \n
        }\n"
);
insert into solucion
values (1,3, "public String alarmClock(int day, boolean vacation) \n
            {\n
              String alarm=\"\"; \n
              if (vacation == true && (day ==0)||(day==6)) \n
              {\n
                alarm = \"off\"; \n
              }\n
              else \n
              {\n
                if (vacation == true && (day != 0)||( day != 6))\n
                alarm = \"10:00\";\n
              }\n
              switch (day)\n
              {\n
                case 0:\n
                  //Cuando es domingo \n
                  if (vacation == false)\n
                    alarm = \"10:00\";\n
                  break; \n
                case 1:\n
                  //Cuando es lunes\n
                  if (vacation == false)\n
                    alarm = \"7:00\";\n
                   break;\n
                case 2: \n
                  //Cuando es martes \n
                   if (vacation == false)\n
                    alarm = \"7:00\";\n
                  break;\n
                case 3:\n
                  //Cuadno es miercoles \n
                   if (vacation == false)\n
                    alarm = \"7:00\";\n
                  break;\n
                case 4: \n
                  //Cuando es jueves \n
                 if (vacation == false)\n
                    alarm = \"7:00\";\n
                  break;\n
                case 5: \n
                  //Cuando es viernes \n
                 if (vacation == false)\n
                    alarm = \"7:00\";\n
                  break;\n
                case 6:\n
                  //Cuando es sabado\n
                   if (vacation == false)\n
                    alarm = \"10:00\";\n
                  break; \n
              }\n
              return alarm; \n
            }");

insert into solucion
values (1,4, "public boolean shareDigit(int a, int b) \n
        {\n
          boolean v = false; \n
          int decA, decB,uniA,uniB;\n
          decA = a/10; \n
          decB = b/10; \n
          uniA= a%10; \n
          uniB=b%10; \n
          \n
          if (decA==decB || decA == uniB)\n
            v = true;\n
          else\n
          {\n
           v = false; \n
          if (uniA == decB || uniA==uniB)\n
           v = true; \n
           else \n
           v= false; \n
         }\n
        return v;\n
        }");

insert into solucion
values (1,5, "public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) \n
        {\n
          boolean ans = false; \n
          if (isMorning == true)\n
          {\n
            ans = false; \n
            if (isMom==true)\n
            {\n
              ans = true; \n
            }\n
            else \n
            {\n
              ans = false; \n
            }\n
          }\n
          else \n
          {\n
            if(isAsleep== false )\n
            {\n
              ans = true;\n
            }\n
            else \n
            {\n
              ans = false; \n
            }\n
          }\n
         return ans;  \n
        }");

insert into solucion
values (1,6, "public boolean has271(int[] nums) {\n
          int len = nums.length;\n
          for (int i = 0; i < nums.length - 1; i++) {  \n
            if (i+2 <= nums.length - 1){\n
              int j = Math.abs(nums[i] - 1); \n
              int k = Math.abs(j - nums[i+2]);        \n
              \n
            if(nums[i+1] == nums[i]+5 && k <= 2)\n
                return true;     \n
            }   \n
          } return false;\n
        }");

insert into solucion
values (2,6, "public boolean has271(int[] nums) {\n
          // Iterate < length-2, so can use i+1 and i+2 in the loop.\n
          // Return true immediately when seeing 271.\n
          for (int i=0; i < (nums.length-2); i++) {\n
            int val = nums[i];\n
            if (nums[i+1] == (val+5) &&              // the \"7\" check\n
              Math.abs(nums[i+2] - (val-1)) <= 2) {  // the \"1\" check\n
                return true;\n
            }\n
          }\n
          \n
          // If we get here ... none found.\n
          return false;\n
        }");



insert into solucion
values (1,7,"public boolean evenlySpaced(int a, int b, int c) {\n
                    int a1=a;\n
                    int b1=b;\n
                    int c1=c;\n
                    if((c1-b1) == (b1-a1) || (b1-c1)==(c1-a1)||(a1-c1)==(c1-b1)||(b1-a1)==(a1-c1))\n
                    {\n
                        return true;\n
                    }\n
                    return false;\n
            \n
                }");

insert into solucion
values (1,8, "public Map<String, String> pairs(String[] strings) {\n
           \n
          Map<String, String> map = new HashMap<String, String>();\n
           \n
          for (int i = 0; i < strings.length; i++) {\n
            String tmp   = strings[i];\n
            String first = String.valueOf(tmp.charAt(0));\n
            String last  = String.valueOf(tmp.charAt(tmp.length() - 1));\n
            map.put(first, last);\n
          }\n
          return map;\n
        }");
insert into solucion
values (1,9, "public String[] allSwap(String[] strings) {\n
          Map<String, Integer> map = new HashMap<String, Integer>();\n
          for (int i = 0; i < strings.length; i++) {\n
            String key = String.valueOf(strings[i].charAt(0));\n
            if (map.containsKey(key)) {\n
              // swap\n
              int    pos   = map.get(key); \n
              String tmp   = strings[pos];\n
              strings[pos] = strings[i];\n
              strings[i]   = tmp ;\n
              // delete\n
              map.remove(key);\n
               \n
            } else {\n
              map.put(key, i);\n
            }\n
          }\n
          return strings;\n
        }");





