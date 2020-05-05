<p><b>Esse programa visa resolver o problema da riptografia de Júlio César</b><qp></qp>

Oferecido e incentivado pela <i>Codenation</i>
https://www.codenation.dev

________________________

Essa criptografia se baseia na substituição da letra do alfabeto avançado um determinado número de casas. Por exemplo, considerando o número de casas = 3:

<b>Normal:</b> a ligeira raposa marrom saltou sobre o cachorro cansado
<br/><b>Cifrado:</b> d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr

_____________________________
<b>Regras</b>
______________
As mensagens serão convertidas para minúsculas tanto para a criptografia quanto para descriptografia.
No nosso caso os números e pontos serão mantidos, ou seja:

Normal: 1a.a
Cifrado: 1d.d

Escrever um programa, que faça uma requisição HTTP para a url fornecida.

{
<br/>   "numero_casas": 10,
<br/>	"token":"token_do_usuario",
<br/>	"cifrado": "texto criptografado",
<br/>	"decifrado": "aqui vai o texto decifrado",
<br/>	"resumo_criptografico": "aqui vai o resumo"
<br/>}

<ol>
<li> primeiro passo é salvar o conteúdo do JSON em um arquivo com o nome answer.json, que irá usar no restante do desafio.</li>

<li>Usar o número de casas para decifrar o texto e atualizar o arquivo JSON, no campo decifrado. O próximo passo é gerar um resumo criptográfico do texto decifrado usando o algoritmo sha1 e atualizar novamente o arquivo JSON. OBS: 
Usar qualquer biblioteca de criptografia da sua linguagem de programação favorita para gerar o resumo sha1 do texto decifrado.</li>

<li>O programa deve submeter o arquivo atualizado para correção via POST para a API:<br/>
https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=SEU_TOKEN</li></ol><br/>
OBS: a API espera um arquivo sendo enviado como multipart/form-data, como se fosse enviado por um formulário HTML, com um campo do tipo file com o nome answer. Considere isso ao enviar o arquivo.