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
codigo varchar(1000),
constraint pk1solucion primary key (idSolucion,idProblema),
constraint fk1solucion foreign key (idProblema) references problema(idProblema));

--Insercion de datos--
insert into problema
values (1,"ArrayCount","WARMUP",2);

insert into problema
values (2,"roundSum","LOGIC",2);

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
        \n
        if(b%10 >4)\n
           sum+=(b/10+1)*10;\n
        else\n
           sum+=(b/10)*10;\n
        \n
        if(c%10 >4)\n
           sum+=(c/10+1)*10;\n
        else\n
           sum+=(c/10)*10;\n
        \n
         return sum; \n
        }\n
        \n"
);


