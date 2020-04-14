package jp.ksf.sukawasatoru.training;

import java.io.PrintWriter;
import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        java.io.PrintWriter writer = new PrintWriter(System.out);
        final Vault vault = new Vault(VaultDoorState.Close, VaultKeyState.Unlock);
        while (true) {
            writer.print("> ");
            writer.println(scanner.nextLine());
        }
    }

    private static void printVault(PrintWriter w, Vault vault) {
        w.println("Vault Key: " + getKeyStateString(vault.getKeyState()) + ", Door: " + getDoorStateString(vault.getDoorState()));
    }

    private static String getKeyStateString(VaultKeyState state) {
        switch (state) {
            case Lock:
                return "Locked";
            case Unlock:
                return "Unlocked";
            default:
                throw new UnsupportedOperationException("unexpected state: " + state);
        }
    }

    private static String getDoorStateString(VaultDoorState state) {
        switch (state) {
            case Open:
                return "Opened";
            case Close:
                return "Closed";
            default:
                throw new UnsupportedOperationException("unexpected state: " + state);
        }
    }
}
