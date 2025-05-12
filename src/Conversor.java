public record Conversor (String moedaOriginal,
                        String moedaDesejada,
                        float valorOriginal ,
                        float valorConvertido
                        ) {
    // isso é um construtor canonico, é criado automaticamento e pode ser personalizado tbm
    public Conversor( ReferenciaEnchangeApi referenciaEnchangeApi, float valorOriginal){
          this(
                  referenciaEnchangeApi.base_code(),
                  referenciaEnchangeApi.target_code(),
                  valorOriginal,
                  valorOriginal * referenciaEnchangeApi.conversion_rate()
          );
    }
}
