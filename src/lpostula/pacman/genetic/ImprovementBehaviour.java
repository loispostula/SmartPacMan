package lpostula.pacman.genetic;


/**
 * Created by lpostula on 25/02/14.
 * Documentation de la classe ImprovementBehaviour
 */
public class ImprovementBehaviour {

    /**
     * Replace byte [ ].
     *
     * @param genome       the genome
     * @param pos          the pos
     * @param sizeReplaced the size replaced
     * @param sequence     the sequence
     * @return the byte [ ]
     * @throws Exception the exception
     */
    protected byte[] replace(byte[] genome, int pos, int sizeReplaced, byte[] sequence) throws Exception {
        if (genome.length < sequence.length)
            throw new Exception("Wrong sequence size, > genome.length");
        if (pos < 0)
            throw new Exception("Position is negative");
        if (sizeReplaced < sequence.length)
            throw new Exception("Wrong sequence size, > sizeReplaced");
        byte[] newGenome = genome.clone();
        System.arraycopy(sequence, 0, newGenome, pos, sequence.length);

        int copyPos = pos + sizeReplaced;
        int endOfNewSequence = pos + sequence.length;
        for (int i = 0; i < newGenome.length - copyPos; i++) {
            genome[i + endOfNewSequence] = genome[i + copyPos];
        }
        int endOfGenome = newGenome.length - copyPos;
        newGenome = Individual.fillBlank(newGenome, endOfGenome);
        return newGenome;
    }

    /**
     * Improve byte [ ].
     *
     * @param individual the individual
     * @return the byte [ ]
     */
    public byte[] improve(Individual individual) {
        byte[] newGenome = individual.getGenome().clone();
        /*for(int i=0; i < newGenome.length; i++){
            Vector vector = new Vector();
            byte val = newGenome[i];
            if(val == Individual.RIGHT)
                vector.x+=1;
            else if(val == Individual.LEFT)
                vector.x-=1;
            else if(val == Individual.UP)
                vector.y-=1;
            else if(val == Individual.DOWN)
                vector.y+=1;
            for(int j=i+1; j < newGenome.length; j++){
                val = newGenome[j];
                if(val == Individual.RIGHT)
                    vector.x+=1;
                else if(val == Individual.LEFT)
                    vector.x-=1;
                else if(val == Individual.UP)
                    vector.y-=1;
                else if(val == Individual.DOWN)
                    vector.y+=1;
                byte[] element = new byte[1];
                try{
                    if(vector.x == 1 && vector.y == 0){
                        element[0]=Individual.RIGHT;
                        newGenome = this.replace(newGenome, i, j-i, element);
                        return newGenome;
                    }else if(vector.x == -1 && vector.y == 0){
                        element[0]=Individual.LEFT;
                        newGenome = this.replace(newGenome, i, j-i, element);
                        return newGenome;
                    }else if(vector.x == 0 && vector.y == 1){
                        element[0]=Individual.DOWN;
                        newGenome = this.replace(newGenome, i, j-i, element);
                        return newGenome;
                    }else if(vector.x == 0 && vector.y == -1){
                        element[0]=Individual.UP;
                        newGenome = this.replace(newGenome, i, j-i, element);
                        return newGenome;
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    System.exit(-1);
                }
            }
        }*/
        //now we will remove the there and back again
        byte[] gen = individual.getGenome();
        byte[] newgen = new byte[gen.length];
        int added = 0;
        int i = 0;
        while (i < gen.length - 1) {
            if (gen[i + 1] != invert(gen[i])) {
                newgen[added] = gen[i];
                ++added;
            } else {
                ++i;
            }
            ++i;
        }
        newgen = Individual.fillBlank(newgen, added);
        return individual.getGenome();
    }

    private byte invert(byte i) {
        switch (i) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
        }
        ;
        return 0;
    }
}
