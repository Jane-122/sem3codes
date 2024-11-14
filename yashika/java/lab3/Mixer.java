import java.util.Scanner;

public class Mixer {

   int[] arr;

   void accept() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the number of elements: ");
      int n = scanner.nextInt();
      arr = new int[n];

      System.out.println("Enter the elements in ascending order:");
      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }
    }

   Mixer mix(Mixer A) {
      int[] B = A.arr;
      int[] result = new int[arr.length + B.length];
      int i = 0, j = 0, k = 0;

      while (i < arr.length && j < B.length) {
         if (arr[i] < B[j]) {
               result[k++] = arr[i++];
         } 
         else {
            result[k++] = B[j++];
         }
      }

      while (i < arr.length) {
         result[k++] = arr[i++];
      }

      while (j < B.length) {
         result[k++] = B[j++];
      }

      Mixer mergedMixer = new Mixer();
      mergedMixer.arr = new int[k];
      System.arraycopy(result, 0, mergedMixer.arr, 0, k);
      return mergedMixer;
   
   }

   void display() {
         for (int num : arr) {
            System.out.print(num + " ");
         }
         System.out.println();
   }

   public static void main(String[] args) {
      Mixer mixer1 = new Mixer();
      Mixer mixer2 = new Mixer();

      System.out.println("Enter elements for the first array:");
      mixer1.accept();

      System.out.println("Enter elements for the second array:");
      mixer2.accept();

      Mixer mergedMixer = mixer1.mix(mixer2);

      System.out.println("Merged array:");
      mergedMixer.display();
   }
}