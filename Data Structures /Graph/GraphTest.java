import java.util.ArrayList;

public class GraphTest{

        /*
                Note: I understood the task like this: Anatjari tries to make as few stops as possible and every time he walks by a waterhole  he stops and refills his bottle
        */
    public static void main(String[] args) {

            Graph<String, Integer> graph=new Graph<>();

            //vertices
            Vertex<String> a=new Vertex<>("A");
            Vertex<String> b=new Vertex<>("B");
            Vertex<String> c=new Vertex<>("C");
            Vertex<String> d=new Vertex<>("D");
            Vertex<String> e=new Vertex<>("E");
            Vertex<String> f=new Vertex<>("F");
            Vertex<String> g=new Vertex<>("G");
            Vertex<String> h=new Vertex<>("H");
            Vertex<String> i=new Vertex<>("I");
            Vertex<String> j=new Vertex<>("J");
            Vertex<String> k=new Vertex<>("K");
            Vertex<String> l=new Vertex<>("L");
            Vertex<String> m=new Vertex<>("M");
            Vertex<String> n=new Vertex<>("N");
            Vertex<String> o=new Vertex<>("O");
            Vertex<String> p=new Vertex<>("P");
            Vertex<String> q=new Vertex<>("Q");
            Vertex<String> r=new Vertex<>("R");
            Vertex<String> s=new Vertex<>("S");
            Vertex<String> t=new Vertex<>("T");
            Vertex<String> u=new Vertex<>("U");

            Vertex[] v={a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u};
            ArrayList<Vertex<String>> vertices=new ArrayList<>();

            for (int z=0; z<v.length; z++ ){
                vertices.add(v[z]);
            }
            //edges
            Edge<String, Integer> edge1=new Edge<>(o,a,2); graph.addEdge(edge1);
            Edge<String, Integer> edge2=new Edge<>(b,n,2); graph.addEdge(edge2);
            Edge<String, Integer> edge3=new Edge<>(b,a,2); graph.addEdge(edge3);
            Edge<String, Integer> edge4=new Edge<>(n,b,2); graph.addEdge(edge4);
            Edge<String, Integer> edge5=new Edge<>(b,c,7); graph.addEdge(edge5);
            Edge<String, Integer> edge6=new Edge<>(c,d,3); graph.addEdge(edge6);
            Edge<String, Integer> edge7=new Edge<>(c,f,4); graph.addEdge(edge7);
            Edge<String, Integer> edge8=new Edge<>(n,m,4); graph.addEdge(edge8);
            Edge<String, Integer> edge9=new Edge<>(t,m,1); graph.addEdge(edge9);
            Edge<String, Integer> edge10=new Edge<>(m,f,4); graph.addEdge(edge10);
            Edge<String, Integer> edge11=new Edge<>(g,f,5); graph.addEdge(edge11);
            Edge<String, Integer> edge12=new Edge<>(m,q,4); graph.addEdge(edge12);
            Edge<String, Integer> edge13=new Edge<>(q,l,5); graph.addEdge(edge13);
            Edge<String, Integer> edge14=new Edge<>(q,r,4); graph.addEdge(edge14);
            Edge<String, Integer> edge15=new Edge<>(k,l,5); graph.addEdge(edge15);
            Edge<String, Integer> edge16=new Edge<>(l,f,7); graph.addEdge(edge16);
            Edge<String, Integer> edge17=new Edge<>(d,g,6); graph.addEdge(edge17);
            Edge<String, Integer> edge18=new Edge<>(g,h,2); graph.addEdge(edge18);
            Edge<String, Integer> edge19=new Edge<>(d,h,5); graph.addEdge(edge19);
            Edge<String, Integer> edge20=new Edge<>(d,i,6); graph.addEdge(edge20);
            Edge<String, Integer> edge21=new Edge<>(g,k,5); graph.addEdge(edge21);
            Edge<String, Integer> edge22=new Edge<>(k,e,3); graph.addEdge(edge22);
            Edge<String, Integer> edge23=new Edge<>(k,r,2); graph.addEdge(edge23);
            Edge<String, Integer> edge24=new Edge<>(r,p,6); graph.addEdge(edge24);
            Edge<String, Integer> edge25=new Edge<>(e,p,1); graph.addEdge(edge25);
            Edge<String, Integer> edge26=new Edge<>(p,j,3); graph.addEdge(edge26);
            Edge<String, Integer> edge27=new Edge<>(e,j,1); graph.addEdge(edge27);
            Edge<String, Integer> edge28=new Edge<>(h,e,2); graph.addEdge(edge28);
            Edge<String, Integer> edge29=new Edge<>(h,i,3); graph.addEdge(edge29);
            Edge<String, Integer> edge30=new Edge<>(i,j,5); graph.addEdge(edge30);
            Edge<String, Integer> edge31=new Edge<>(i,s,4); graph.addEdge(edge31);
            Edge<String, Integer> edge32=new Edge<>(j,s,2); graph.addEdge(edge32);
            Edge<String, Integer> edge33=new Edge<>(u,s,1); graph.addEdge(edge33);

            GraphAnatjari<String, Integer> anatjari=new GraphAnatjari<String, Integer>(5, graph);
            anatjari.removeEdge();
            anatjari.findPaths(t,u, new ArrayList<>());
            System.out.println("Anatjari should decide for this path: "+ anatjari.getShortestPath());
        }

    }



