DROP TABLE IF EXISTS admin;

create table admin(
id int(50)primary key auto_increment,
username varchar(20),
password varchar(20),
Fav_food varchar(20),
emailID varchar(30),
SPIN int(20),
Name varchar(20),
Nick_name varchar(20),
mobileNO bigInt(20),
address varchar(50));

insert into admin values(1,'admin','admin','null','null',null,'admin','admin',null,'vasai');

DROP TABLE IF EXISTS user;

create table user(
id int(50)primary key auto_increment,
username varchar(20),
password varchar(20),
Fav_food varchar(20),
emailID varchar(30),
SPIN int(20),
Name varchar(20),
Nick_name varchar(20),
mobileNO bigInt(20),
address varchar(50));
insert into user values(1,'admin','admin','null','null',null,'admin','admin',null,'vasai');
drop table if exists menu;

create table menu(
    icode int(11) primary key auto_increment,
    iname varchar(50),iprice bigInt(20));

    insert into menu values (NULL,'Hot & Sour Soup         ','100'),			
			(NULL,'Noodle Soup             ','130'),
			(NULL,'Sweet Corn Mushroom     ','150'),
			(NULL,'Sweet Corn Soup         ','130'),
			(NULL,'Sweet Corn Veg Soup     ','110'),
			(NULL,'Tomato Soup             ','100'),
			(NULL,'Veg Manchow Soup        ','110'),
			(NULL,'Veg Soup                ','115'),
			(NULL,'Curd                    ','50'),
			(NULL,'Veg Raita               ','70'),
			(NULL,'Boondi Raita            ','90'),
			(NULL,'Chass                   ','45'),
			(NULL,'Lassi                   ','65'),
			(NULL,'Water Bottle            ','30'),
			(NULL,'Roasted Papad           ','30'),
			(NULL,'Masala Papad            ','50'),
			(NULL,'Green Salad             ','90'),
			(NULL,'Malai Kofta             ','230'),
			(NULL,'Mushroom Masala         ','220'),
			(NULL,'Mushroom Paneer Mutter  ','230'),
			(NULL,'Mutter Paneer           ','190'),
			(NULL,'Palak Paneer            ','180'),
			(NULL,'Paneer Bhurji           ','200'),
			(NULL,'Paneer Butter Masala    ','250'),
			(NULL,'Paneer Chatpata         ','170'),
			(NULL,'Paneer Do Pyaaza        ','240'),
			(NULL,'Paneer Hyderabadi       ','235'),
			(NULL,'Paneer Kadai            ','220'),
			(NULL,'Paneer Makhanwala       ','210'),
			(NULL,'Paneer Tikka Masala     ','230'),
			(NULL,'Dal Fry                 ','120'),
			(NULL,'Dal Tadka               ','140'),
			(NULL,'Jeera Dal Tadka         ','160'),
			(NULL,'Hydrabadi Briyani       ','245'),
			(NULL,'Jeera Rice              ','135'),
			(NULL,'Steam Rice              ','115'),
			(NULL,'Tawa Pulav              ','155'),
			(NULL,'Veg Biryani             ','220'),
			(NULL,'Veg Pulav               ','185'),
			(NULL,'Combination Rice (R/N/M)','195'),
			(NULL,'Fried Rice              ','160'),
			(NULL,'Garlic Fried Rice       ','180'),
			(NULL,'Manchurian Rice(Dry)    ','195'),
			(NULL,'Manchurian Rice(Gravy)  ','210'),
			(NULL,'Mushroom Fried Rice     ','195'),
			(NULL,'Triple Rice             ','225'),
			(NULL,'Veg Schezwan Rice       ','190'),
			(NULL,'Baby Corn Chilly Dry    ','195'),			
			(NULL,'Dry Manchurian          ','155'),
			(NULL,'Gobi Chilly Dry         ','170'),
			(NULL,'Gobi Manchurian         ','150'),
			(NULL,'Gravy Manchurian        ','165'),
			(NULL,'Mashroom Hot Garlic     ','180'),
			(NULL,'Mushroom Chilly         ','180'),
			(NULL,'Mushroom Paneer Chilly  ','190'),
			(NULL,'Paneer 65               ','195'),
			(NULL,'Paneer Chilly           ','190'),
			(NULL,'Paneer Crispy           ','185'),
			(NULL,'Paneer Hot Garlic       ','220'),
			(NULL,'Paneer Schezwan         ','200'),
			(NULL,'Veg 65                  ','210'),
			(NULL,'Veg Chilly              ','120'),
			(NULL,'Veg Chilly milly        ','150'),
			(NULL,'Veg Crispy              ','150'),
			(NULL,'Veg Lollipop (8 pcs)    ','170'),
			(NULL,'Aloo Gobi(Dry)          ','180'),
			(NULL,'Aloo Gobi(Gravy)        ','220'),
			(NULL,'Aloo Mutter             ','160'),
			(NULL,'Aloo Panjabi            ','195'),
			(NULL,'Bhindi Do Pyaaza        ','200'),
			(NULL,'Bhindi Masala           ','160'),
			(NULL,'Chole Masala            ','180'),
			(NULL,'Dewani Handi            ','270'),
			(NULL,'Jeera Aloo              ','120'),
			(NULL,'Mix Veg Masala          ','230'),
			(NULL,'Veg Banjara             ','190'),
			(NULL,'Veg Bhuna               ','190'),
			(NULL,'Veg Kadai               ','240'),
			(NULL,'Veg Kasturi             ','180'),
			(NULL,'Veg Keema               ','255'),
			(NULL,'Veg Kofta               ','220'),
			(NULL,'Veg Kolhapuri           ','190'),
			(NULL,'Veg Makhanwala          ','220'),
			(NULL,'Veg Maratha             ','220'),
			(NULL,'Butter Naan             ','47'),
			(NULL,'Butter Roti             ','37'),
			(NULL,'Naan                    ','42'),
			(NULL,'Roti                    ','33'),
			(NULL,'Butter Chapati          ','35'),
			(NULL,'Chapati                 ','25'),
			(NULL,'Desi Ghee Chapati       ','40'),
			(NULL,'Mushroom Noodles        ','170'),
			(NULL,'Singapori Noodles       ','220'),
			(NULL,'Veg Hakka Noodles       ','185'),
			(NULL,'Veg Schezwan Noodles    ','175'),
			(NULL,'Extra Schezwan Sauce    ','25'),
			(NULL,'Parcel charge           ','5');


drop table if exists waiter;

create table waiter(
    WID int(50) primary key,
    wname varchar(20),
	waddress varchar(50),
    wemailid varchar(40),
    wmobileno bigInt(20));
    


create table waiter(
    WID int(50) primary key,
    wname varchar(20),
    wemailid varchar(40),
    wmobileno bigInt(20),
    waddress varchar(50));

insert into waiter values(1,'mukesh','mukesh@gmail.com',null,null);

DROP TABLE IF EXISTS orderdetail;

    create table orderdetail(
        DATE_n_TIME datetime,
        WID int(10),WNAME varchar(20),TABLE_NO int(10),NO_OF_PEOPLE INT(10),ICODE INT(10),
        INAME varchar(20),QTY INT(10),IPRICE INT(10),AMOUNT INT(10));
    
DROP TABLE IF EXISTS orde;
create TABLE orderplaced(
    code int(11),iname varchar(30),qty int(11),rate int(11),amt int(11),Date_time datetime,
    invoice_no int(11),table_no varchar(11),noOfppl varchar(10),wname varchar(30),total_item int(11),
    total_qty int(11),total_amt int(11),date date,cash_recd int(10),cash_retd varchar(10),
    card_no bigInt(20),cashier varchar(20),ordertype varchar(20));

create TABLE orderplaced(
    code int(11),iname varchar(30),qty int(11),rate int(11),amt int(11),Date_time datetime,
    invoice_no int(11),table_no varchar(11),noOfppl varchar(10),wname varchar(30),total_item int(11),
    total_qty int(11),total_amt int(11),cash_recd int(10),cash_retd varchar(10),
    card_no bigInt(20),cashier varchar(20),ordertype varchar(20));

DROP TABLE IF EXISTS bkptblvalue;
create TABLE bkptblvalue(
    code int(11),iname varchar(30),qty int(11),rate int(11),amt int(11),Date_time datetime,
    invoice_no int(11),table_no varchar(11),noOfppl varchar(10),wname varchar(30),total_item int(11),
    total_qty int(11),total_amt int(11),date date,cash_recd int(10),cash_retd varchar(10),
    card_no bigInt(20),cashier varchar(20),ordertype varchar(20));
