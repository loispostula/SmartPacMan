/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lpostula.pacman.genetic;

import java.util.Random;

/**
 * The type Sort.
 *
 * @author tpasquie
 */
public class Sort {
    /**
     * The Rand.
     */
    static protected Random rand = new Random();

    /**
     * Quick sort.
     *
     * @param pop the pop
     */
    public static void QuickSort(Object[] pop) {
        Sort.QuickSort(pop, 0, pop.length - 1);
    }

    private static int Partition(Object[] array, int left, int right) {
        int p = left;
        for (int i = left + 1; i <= right; i++) {
            if (((Individual) array[left]).getFitnessScore() < ((Individual) array[i]).getFitnessScore()) {
                Object tmp = array[p + 1];
                array[p + 1] = array[i];
                array[i] = tmp;
                p++;
            }
        }
        Object tmp = array[p];
        array[p] = array[left];
        array[left] = tmp;
        return p;
    }

    private static void QuickSort(Object[] array, int left, int right) {
        if (right > left) {
            int p = Partition(array, left, right);
            QuickSort(array, left, p - 1);
            QuickSort(array, p + 1, right);
        }
    }
}
