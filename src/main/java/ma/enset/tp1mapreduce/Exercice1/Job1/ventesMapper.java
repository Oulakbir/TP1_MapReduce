package ma.enset.tp1mapreduce.Exercice1.Job1;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ventesMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable prix = new IntWritable();
    private Text ville = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] champs = value.toString().split(" ");
        ville.set(champs[1]);
        prix.set(Integer.parseInt(champs[3]));
        context.write(ville, prix);
    }
}