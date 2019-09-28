hepsi:derle	calistir
derle:
	gcc -I ./include/ -o ./lib/Random.o -c ./src/Random.c
	gcc -I ./include/ -o ./lib/RastgeleKarakter.o -c ./src/RastgeleKarakter.c
	gcc -I ./include/ -o ./bin/Test ./lib/RastgeleKarakter.o ./lib/Random.o ./src/Test.c
calistir:
	./bin/Test