package mapstruct.nestedmapping;

import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T21:00:17+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student getModelFromEntity(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        Student student = new Student();

        student.setSubject( subjectEntityToSubject( studentEntity.getSubject() ) );
        student.setClassName( studentEntity.getClassVal() );
        student.setAuthor( authorEntityToAuthor( studentEntity.getAuthorEntity() ) );
        student.setId( studentEntity.getId() );
        student.setName( studentEntity.getName() );

        return student;
    }

    @Override
    public StudentEntity getEntityFromModel(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setSubject( subjectToSubjectEntity( student.getSubject() ) );
        studentEntity.setClassVal( student.getClassName() );
        studentEntity.setAuthorEntity( authorToAuthorEntity( student.getAuthor() ) );
        studentEntity.setId( student.getId() );
        studentEntity.setName( student.getName() );

        return studentEntity;
    }

    @Override
    public void merge(StudentEntity studentEntity, StudentEntity studentEntity1) {
        if ( studentEntity == null ) {
            return;
        }

        studentEntity1.setId( studentEntity.getId() );
        studentEntity1.setName( studentEntity.getName() );
        studentEntity1.setClassVal( studentEntity.getClassVal() );
        studentEntity1.setSubject( studentEntity.getSubject() );
        studentEntity1.setAuthorEntity( studentEntity.getAuthorEntity() );
    }

    protected Author authorEntityToAuthor(AuthorEntity authorEntity) {
        if ( authorEntity == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( authorEntity.getName() );
        author.setPhnNo( authorEntity.getPhnNo() );

        return author;
    }

    protected Subject subjectEntityToSubject(SubjectEntity subjectEntity) {
        if ( subjectEntity == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setAuthor( authorEntityToAuthor( subjectEntity.getAuthor() ) );
        subject.setName( subjectEntity.getName() );

        return subject;
    }

    protected AuthorEntity authorToAuthorEntity(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setName( author.getName() );
        authorEntity.setPhnNo( author.getPhnNo() );

        return authorEntity;
    }

    protected SubjectEntity subjectToSubjectEntity(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectEntity subjectEntity = new SubjectEntity();

        subjectEntity.setAuthor( authorToAuthorEntity( subject.getAuthor() ) );
        subjectEntity.setName( subject.getName() );

        return subjectEntity;
    }
}
