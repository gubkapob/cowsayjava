# Cow say in Java

My fun project. Applied architectural c4 notation.

a) console version

For run application need open terminal and input folow cmd...
```shell
docker-compose up -d 
docker attach cowsay_console

# or

docker-compose run --rm cowsay
```

User input: "I love Java"  
And Cow say:
 _____________
< I love Java >
-------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||

User input: "exit"  
And Cow say:
 ______
\< Bye! \>
------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||

User input: empty string input  
And out: --> Empty line detected <-- Program exiting!

