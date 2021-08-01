package br.com.sa;

import br.com.sa.model.Pesquisa;
import br.com.sa.repository.PesquisaRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LoadData implements CommandLineRunner {
    @Autowired
    PesquisaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Pesquisa pesquisaUrb= new Pesquisa();
        pesquisaUrb.setAuthor("Rodrigo Conti Ribeiro");
        pesquisaUrb.setTitle("Pesquisa sobre arte urbana");
        pesquisaUrb.setParagraphs("Para primeiro falar sobre a Arte Urbana, é preciso desvendar a terminologia usada no meio, e diferenciá-la de outras palavras usadas talvez erroneamente de forma intercambiável, como o graffiti (grafito) e a arte de rua(street art ou S.a).\n" +
                "\n" +
                "                De forma cronológica pode-se colocar o grafito em primeiro, ele seria uma forma de expressão quase que exclusivamente estadunidense e que seria mais “primitiva” que as outras duas. Ela foi e é uma forma de “escrita”, para marcar alguma forma de ícone e/ou assinatura no espaço urbano. Essas “assinaturas urbanas” muitas vezes tinham motivações espontâneas e pessoais, como uma forma de se mostrar para o mundo. Elas são divididas em duas categorias, as tags e as masterpieces, as primeiras são apenas escritas normais e legíveis, enquanto as últimas são quase como “murais” mais elaborados que possuem um maior grau de abstração e menos inteligibilidade. Normalmente ambos os tipos eram aplicados às superfícies usando latas de aerossol colorido, um traço marcante desse estilo é o escopo de inteligibilidade, normalmente as letras eram estilizadas de tal forma que era virtualmente impossível de uma pessoa de fora do círculo do autor entender, e mesmo que entendesse poderia ser pouco compreensível.\n" +
                "\n" +
                "                Após a formação do grafito, vem a arte de rua, que já abrange diversas formas de expressão, como exposições 3D, yarn art, pôsteres, adesivos, pinturas e murais. Não me estenderei na enumeração das formas de expressão, se o leitor assim desejar ver mais sobre isso, que pesquise no google fotografias sobre, será muito mais útil e entendível. A arte de rua pode ser considerada mais desenvolvida que o grafito, as diferenças entre o grafito e a arte de rua podem ser enumeradas assim: Dano e Permanência, Estética, Ameaça e Compreensibilidade. A S.a é menos danosa e permanente ao ambiente urbano, além de ser mais “bonita” aos olhos, e por ser desrelacionada a gangues e criminais é menos “ameaçadora”, por fim é mais compreensível ao público por não possuir os elementos restritos aos grupos que produziram as obras. Outro fator diferenciador muito importante é o engajamento político que a S.a se envolve.\n" +
                "\n" +
                "                De forma sintética a arte de rua é: “Street Art consiste de pinturas, caracteres, e formas criadas em ou aplicadas em superfícies de um espaço urbano de forma auto-autorizada para intencionalmente procurar comunicar-se com um círculo maior de pessoas. Street Art é realizada de forma performativa e frequentemente específica ao local, efêmera e participativamente”(tradução livre do inglês) Antes de pular para a Arte Urbana(A.u) é necessário compreender o contexto criminal e legal dessas obras artísticas, os dois movimentos citados, o grafito e a S.a são predominantemente ilegais, e a adrenalina causada pela ilegalidade é presente nas suas culturas. Por outro lado, a A.u é legal e é compensada pecuniariamente, por meio de encomendas.\n" +
                "\n" +
                "                Agora por fim vem a Arte Urbana, que é a forma legal e institucionalizada dos outros movimentos já citados, ou seja, você verá instituições ou indivíduos, públicos ou privados contratando e pagando os serviços de artistas urbanos, além de suas obras serem expostas em museus e galerias através do mundo.");
        File imageUrb = new File("src/main/resources/static/images/backgroundUrban.png");
        pesquisaUrb.setImage(FileUtils.readFileToByteArray(imageUrb));
        repository.save(pesquisaUrb);

        Pesquisa pesquisaPop = new Pesquisa();
        pesquisaPop.setAuthor("Claudio Conti Ribeiro");
        pesquisaPop.setTitle("Pesquisa sobre a Pop Art");
        pesquisaPop.setParagraphs("A Pop Art foi um movimento artístico que surgiu nos anos 50 na Inglaterra e teve seu pico nos anos 60 em Nova York (EUA), as obras da Pop Art eram artes figurativas com iconografias da televisão, da fotografia, dos quadrinhos, do cinema e publicidade, as obras da Pop Art se focaram principalmente na vida cotidiana popular e no materialismo e consumismo das massas, ironizando seu estilo de vida.\n\n" +
                "As principais características da Pop Art são:\n" +
                "·        Temática da arte com a vida urbana cotidiana usando a linguagem figurativa e realista;\n" +
                "·        Obras com temas como consumo, celebridades, sexualidade e industrialização;\n" +
                "·        Utilização de cores fortes e brilhantes, com o intuito de chamar a atenção;\n" +
                "·        Utilização da técnica silk-screen (ou serigrafia), que é uma técnica de impressão de texto ou figura em uma superfície com tinta vazada;\n" +
                "·        Reprodução em serie das obras, tornando a disponível a todos;\n" +
                "·        Utilização de técnicas de colagem nas obras;\n\n" +
                "Os principais artistas da Pop Art são Andy Warhol (1927-1987), Roy Lichtenstein (1923-1997), Robert Rauschenberg (1925-2008), Jasper Johns (1930), Tom Wesselmann (1931-2004), Claudio Tozzi (1944), Romero Britto (1963), Antonio Dias (1944).\n");
        File imagePop = new File("src/main/resources/static/images/imgPop.jpg");
        pesquisaPop.setImage(FileUtils.readFileToByteArray(imagePop));
        repository.save(pesquisaPop);
    }
}
