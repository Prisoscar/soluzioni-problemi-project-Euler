package eu.prisoscar.euler1.soluzioni;

import org.paukov.combinatorics3.Generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange).
For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.

A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key.
The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text;
for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.

For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes.
The user would keep the encrypted message and the encryption key in different locations, and without both "halves", it is impossible to decrypt the message.

Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.

Your task has been made easy, as the encryption key consists of three lower case characters. Using p059_cipher.txt (right click and 'Save Link/Target As...'),
a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words,
decrypt the message and find the sum of the ASCII values in the original text.
 */
public class Prbl_59_XORDecryption {

    private static final File ENCRYPTED_FILE = new File(System.getProperty("user.dir") + "/p059_cipher.txt");

    public static int getSolution() throws FileNotFoundException {
        AtomicInteger solution = new AtomicInteger();
        String [] stringBytes = new Scanner(ENCRYPTED_FILE).next().split(",");
        final  Byte [] originalBytes =  Arrays.stream(stringBytes).map(Byte::parseByte).collect(Collectors.toList()).toArray(new Byte[stringBytes.length]);
        Generator.combination('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
                .multi(3)
                .stream()
                .forEach(combination -> Generator.permutation(combination)
                        .simple()
                        .stream()
                        .forEach(permutation -> {
                                StringBuilder actualDecodification = new StringBuilder();
                                for (int i = 0; i < originalBytes.length; i++) {
                                    actualDecodification.append((char) ((byte) permutation.get(i % 3).charValue() ^ originalBytes[i]));
                                }
                                if (actualDecodification.toString().toString().contains("Euler")) {
                                    solution.set(Arrays.stream(actualDecodification.toString().chars().toArray()).reduce(0, Integer::sum));
                                }
                        })
                );
        return solution.get();
    }
}