package es.upm.grise.prof2022.ex2;

public interface FileFactoryInterface {
    public String openFile(String key,Language language) throws CannotFindPropertyFileOrWrongFileException;
}
