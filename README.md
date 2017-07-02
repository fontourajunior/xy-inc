# xy-inc
Configurando ambiente:
<ol>
  <li>Faça o clone ou download do projeto https://github.com/fontourajunior/xy-inc.git</>
  <li>Abra a ide de sua preferencia e importe projeto maven existente, e aponte para o local onde o projeto foi baixado.<br>
  Caso esteja usando eclipse:
    <ol>
      <li>File -> Import</li>
      <li>Selecione (Maven -> Exists Maven Projects)</li>
      <li>Avance, aponte para o diretório onde se encontra o projeto e finalize</li>
    </ol>
  </li>
  <li>Com o projeto importado, abre o arquivo Application.java que se encontra eh (src/main/java) no pacote (br.com.zup)</li>
  <li>Execute o projeto (Run -> Run As -> Java Application). <br> O projeto será iniciado.</li>
</ol>

Chamando os serviços:
<ol>
  <li>Abra um cliente HTTP qualquer.</li>
  <li>Exemplo chamada serviço</li>
    <ul>
       <li>
        Serviço para cadastrar pontos de interesse com 3 atributos.<br/>
        POST -> http://localhost:8080/points-interest, com os seguinte parâmetros a serem passados (name, coordinatedX, coordinatedY)<br/>
          Exemplo: {"name": "ZUP","coordinatedX": 30,"coordinatedY": 40}
          </li>
        <li>
          Serviço para listar todos os POIs cadastrados.<br>
          GET -> http://localhost:8080/points-interest
        </li>
        <li>
          Serviço para listar POIs por proximidade.<br>
          GET -> http://localhost:8080/points-interest/points-interest-proximity?coordinateReferenceX=20&coordinateReferenceY=10&distance=10
        </li>
    </ul>
</ol>
