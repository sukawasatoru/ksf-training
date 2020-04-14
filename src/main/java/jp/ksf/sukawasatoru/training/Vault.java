package jp.ksf.sukawasatoru.training;

public class Vault {
    private VaultDoorState doorState;
    private VaultKeyState keyState;
    private int key;
    private int payload;

    public Vault(VaultDoorState doorState, VaultKeyState keyState) {
        this.doorState = doorState;
        this.keyState = keyState;
    }

    public VaultDoorState getDoorState() {
        return doorState;
    }

    public void setDoorState(VaultDoorState vaultDoorState) {
        this.doorState = vaultDoorState;
    }

    public VaultKeyState getKeyState() {
        return keyState;
    }

    public void setKeyState(VaultKeyState vaultKeyState) {
        this.keyState = vaultKeyState;
    }

    /**
     * Store value
     *
     * @param value a value to store
     * @throws IllegalArgumentException a value should range between 0 <= x <= 9999
     */
    public void pushValue(int value) {
        if (value < 0 || 9999 < value) {
            throw new IllegalArgumentException("a value should range between 0 <= x <= 9999");
        }
    }

    /**
     * Open vault
     *
     * @throws IllegalArgumentException if vault locked
     */
    public void tryOpen() {
        if (keyState == VaultKeyState.Lock) {
            throw new IllegalArgumentException("Need to unlock vault");
        }

        doorState = VaultDoorState.Open;
    }

    /**
     * Close vault
     */
    public void tryClose() {
        doorState = VaultDoorState.Close;
    }

    /**
     * Lock vault
     *
     * @param key a lock number
     * @throws IllegalArgumentException if vault is open or locked then exception happen
     */
    public void tryLock(int key) {
        if (doorState == VaultDoorState.Open) {
            throw new IllegalArgumentException("Need to close vault");
        }

        if (keyState == VaultKeyState.Unlock) {
            throw new IllegalArgumentException("Vault already closed");
        }

        this.key = key;
    }

    /**
     * Unlock vault
     *
     * @param key a lock number
     * @throws IllegalArgumentException if vault is open or unlocked then exception happen
     */
    public void tryUnlock(int key) {
        if (doorState == VaultDoorState.Open) {
            throw new IllegalArgumentException("a vault already open");
        }

        if (keyState == VaultKeyState.Unlock) {
            throw new IllegalArgumentException("a vault already unlocked");
        }

        if (this.key == key) {
            doorState = VaultDoorState.Open;
        }
    }
}
