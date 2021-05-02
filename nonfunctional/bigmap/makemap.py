import sys

if __name__ == "__main__":
    print("Generate map for non-functional testing")
    f = open(sys.argv[1], "w");
    numOfTiles = int(sys.argv[2]);
    f.write("worlddata\n    step 0\n    activeplayer none\n    flareparts 0\n")
    f.write("tiles " + str(numOfTiles) + "\n")
    for i in range(numOfTiles):
        f.write("    " + str(i) + " stable 0 n none none\n")
    f.write("tilelinks " + str(numOfTiles * (numOfTiles - 1)) + "\n")
    for i in range(numOfTiles):
        for k in range(i):
            f.write("    " + str(k) + " " + str(i) + "\n")
    f.write("creatures 0\n")
    print("OK")
    f.close();
