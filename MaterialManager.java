import java.util.Scanner;

public class MaterialManager {
    private static final int MAX_MATERIALS = 156;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] materials = new String[MAX_MATERIALS][3];
        int materialsCount = 0;

        boolean continueAdding = true;

        while (continueAdding && materialsCount < MAX_MATERIALS) {
            System.out.println("Enter material details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Height: ");
            String height = scanner.nextLine();

            System.out.print("Length: ");
            String length = scanner.nextLine();

            materials[materialsCount][0] = name;
            materials[materialsCount][1] = height;
            materials[materialsCount][2] = length;

            materialsCount++;

            System.out.print("Do you want to save more materials? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                continueAdding = false;
            }
        }

        System.out.println("\nAll materials are added.");

        boolean continueManaging = true;
        while (continueManaging) {
            System.out.println("\nSelect an option:");
            System.out.println("1. List materials");
            System.out.println("2. Change a material");
            System.out.println("3. Add new materials");
            System.out.println("4. Cancel a material");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after nextInt()

            switch (option) {
                case 1:
                    listMaterials(materials, materialsCount);
                    break;
                case 2:
                    changeMaterial(materials, materialsCount, scanner);
                    break;
                case 3:
                    materialsCount = addNewMaterials(scanner, materials, materialsCount);
                    break;
                case 4:
                    materialsCount = cancelMaterial(materials, materialsCount, scanner);
                    break;
                case 5:
                    continueManaging = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        }
    }

    private static void listMaterials(String[][] materials, int materialsCount) {
        System.out.println("\nList of saved materials:");
        if (materialsCount > 0) {
            for (int i = 0; i < materialsCount; i++) {
                if (materials[i][0] != null) {
                    System.out.println("Material " + (i + 1) + ":");
                    System.out.println("Name: " + materials[i][0]);
                    System.out.println("Height: " + materials[i][1]);
                    System.out.println("Length: " + materials[i][2]);
                    System.out.println();
                }
            }
        } else {
            System.out.println("No materials saved yet.");
        }
    }

    private static void changeMaterial(String[][] materials, int materialsCount, Scanner scanner) {
        if (materialsCount == 0) {
            System.out.println("No materials saved yet.");
            return;
        }

        listMaterials(materials, materialsCount);

        System.out.println("Enter the material number you want to change (1-" + materialsCount + "): ");
        int materialNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after nextInt()

        if (materialNumber < 1 || materialNumber > materialsCount) {
            System.out.println("Invalid material number.");
            return;
        }

        System.out.println("Enter new details for material " + materialNumber + ":");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Height: ");
        String height = scanner.nextLine();

        System.out.print("Length: ");
        String length = scanner.nextLine();

        materials[materialNumber - 1][0] = name;
        materials[materialNumber - 1][1] = height;
        materials[materialNumber - 1][2] = length;

        System.out.println("Material " + materialNumber + " updated successfully.");
    }

    private static int cancelMaterial(String[][] materials, int materialsCount, Scanner scanner) {
        if (materialsCount == 0) {
            System.out.println("No materials saved yet.");
            return materialsCount;
        }

        listMaterials(materials, materialsCount);

        System.out.println("Enter the material number you want to cancel (1-" + materialsCount + "): ");
        int materialNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after nextInt()

        if (materialNumber < 1 || materialNumber > materialsCount) {
            System.out.println("Invalid material number.");
            return materialsCount;
        }

        for (int i = materialNumber - 1; i < materialsCount - 1; i++) {
            materials[i][0] = materials[i + 1][0];
            materials[i][1] = materials[i + 1][1];
            materials[i][2] = materials[i + 1][2];
        }

        materials[materialsCount - 1][0] = null;
        materials[materialsCount - 1][1] = null;
        materials[materialsCount - 1][2] = null;

        materialsCount--;

        System.out.println("Material " + materialNumber + " canceled successfully.");

        return materialsCount;
    }

    private static int addNewMaterials(Scanner scanner, String[][] materials, int materialsCount) {
        boolean continueAdding = true;

        while (continueAdding && materialsCount < MAX_MATERIALS) {
            System.out.println("Enter material details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Height: ");
            String height = scanner.nextLine();

            System.out.print("Length: ");
            String length = scanner.nextLine();

            materials[materialsCount][0] = name;
            materials[materialsCount][1] = height;
            materials[materialsCount][2] = length;

            materialsCount++;

            System.out.print("Do you want to save more materials? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                continueAdding = false;
            }
        }

        System.out.println("\nAll materials are added.");
        return materialsCount;
    }
}
