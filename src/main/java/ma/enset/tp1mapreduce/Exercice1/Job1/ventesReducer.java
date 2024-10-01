package ma.enset.tp1mapreduce.Exercice1.Job1;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ventesReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int somme = 0;
        for (IntWritable val : values) {
            somme += val.get();
        }
        context.write(key, new IntWritable(somme));
    }
}